package at.fhtw.swen3.gps.service;

import at.fhtw.swen3.gps.service.models.Address;
import at.fhtw.swen3.gps.service.models.GeoCoordinate;

import java.util.Optional;

public interface GeoEncodingService {
    Optional<GeoCoordinate> getCoordinates(Address address);

}
