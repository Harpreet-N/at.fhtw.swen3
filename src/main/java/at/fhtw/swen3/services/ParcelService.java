package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.springframework.stereotype.Service;

@Service
public interface ParcelService {

    ParcelEntity reportParcelDelivery(String trackingId);

    ParcelEntity reportParcelHop(String trackingId, String code);

    String submitParcel(ParcelEntity parcel);

    ParcelEntity trackParcel(String trackingId);

    ParcelEntity transferParcel(ParcelEntity parcel);
}
