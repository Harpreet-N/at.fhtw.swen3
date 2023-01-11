package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.ParcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;
    private final GeoEncodingService geoEncodingService;

    @Override
    public Optional<ParcelEntity> reportParcelDelivery(String trackingId) {
        return Optional.empty();
    }

    @Override
    public Optional<ParcelEntity> reportParcelHop(String trackingId, String code) {
        return Optional.empty();
    }

    @Override
    public String submitParcel(ParcelEntity parcel) {
        return null;
    }

    @Override
    public Optional<ParcelEntity> trackParcel(String trackingId) {
        return Optional.empty();
    }

    @Override
    public ParcelEntity transitionParcel(ParcelEntity parcel) {
        return null;
    }
}
