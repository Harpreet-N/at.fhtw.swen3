package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.models.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GeoEncodingServiceImplTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private GeoEncodingServiceImpl geoEncodingService;

    @Test
    public void testGetCoordinatesValidPoint() throws ParseException {
        Address address = new Address("Street", "PostalCode", "City", "Country");
        String json = "[{\"lat\": 12.34, \"lon\": 56.78}]";
        Point expectedPoint = (Point) new WKTReader().read("POINT(12.34 56.78)");
        doReturn(json).when(restTemplate).getForObject(any(URI.class), any());

        Point result = geoEncodingService.getPointFromAddress(address);
        assertEquals(expectedPoint, result);
    }

    @Test
    public void testGetCoordinatesInvalidPoint() {
        Address address = new Address("Street", "PostalCode", "City", "Country");
        doThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST)).when(restTemplate).getForObject(any(URI.class), any());

        Point result = geoEncodingService.getPointFromAddress(address);
        assertNull(result);
    }

    @Test
    public void testUrlForRequest() {
        Address address = new Address("Street", "PostalCode", "City", "Country");
        URI expectedUri = URI.create("https://nominatim.openstreetmap.org/search?street=Street&postalcode=PostalCode&city=City&country=Country&FORMAT_PARAM=jsonv2");

        URI result = geoEncodingService.getUrlFromAddress(address);
        assertEquals(expectedUri, result);
    }
}
