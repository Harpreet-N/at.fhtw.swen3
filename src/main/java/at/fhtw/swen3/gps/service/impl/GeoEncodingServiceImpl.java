package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.gps.service.models.Address;
import at.fhtw.swen3.gps.service.models.GeoCoordinate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Slf4j
public class GeoEncodingServiceImpl implements GeoEncodingService {


    private final RestTemplate restTemplate;

    public GeoEncodingServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Point getPointFromAddress(Address address) {
        URI url = getUrlFromAddress(address);
        try {
            String json = restTemplate.getForObject(url, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            List<GeoCoordinate> coordinates = objectMapper.readValue(json, new TypeReference<>() {
            });
            if (coordinates != null) {
                Optional<GeoCoordinate> tempGeoCoordinate = coordinates.stream().findFirst();
                if (tempGeoCoordinate.isPresent()) {
                    GeoCoordinate geoCoordinate = tempGeoCoordinate.get();
                    String wktPoint = String.format(Locale.US, "POINT(%f %f)", geoCoordinate.getLat(), geoCoordinate.getLon());
                    Point point;
                    try {
                        point = (Point) new WKTReader().read(wktPoint);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    return point;
                }
            }
        } catch (HttpClientErrorException | JsonProcessingException e) {
            log.warn("Error while fetching");
        }
        return null;
    }

    public URI getUrlFromAddress(Address address) {
        return UriComponentsBuilder.fromHttpUrl("https://nominatim.openstreetmap.org/search").queryParam("street", address.getStreet()).queryParam("postalcode", address.getPostalCode()).queryParam("city", address.getCity()).queryParam("country", address.getCountry()).queryParam("FORMAT_PARAM", "jsonv2").build().toUri();
    }
}
