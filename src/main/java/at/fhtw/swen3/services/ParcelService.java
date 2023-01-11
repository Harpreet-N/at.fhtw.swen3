package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ParcelService {

    Optional<ParcelEntity> reportParcelDelivery(String trackingId);

    Optional<ParcelEntity> reportParcelHop(String trackingId, String code);

    String submitParcel(ParcelEntity parcel);

    Optional<ParcelEntity> trackParcel(String trackingId);

    ParcelEntity transitionParcel(ParcelEntity parcel);
}
