package at.fhtw.swen3.gps.service;

import at.fhtw.swen3.gps.service.models.Address;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public interface GeoEncodingService {
    Point getPointFromAddress(Address address);

    URI getUrlFromAddress(Address address);
}
