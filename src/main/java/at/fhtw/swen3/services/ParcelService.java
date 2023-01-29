package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.exception.BLParcelException;
import org.springframework.stereotype.Service;

@Service
public interface ParcelService {

    ParcelEntity reportParcelDelivery(String trackingId) throws BLParcelException;

    ParcelEntity reportParcelHop(String trackingId, String code) throws BLParcelException;

    String submitParcel(ParcelEntity parcel) throws BLParcelException;

    ParcelEntity trackParcel(String trackingId) throws BLParcelException;

    ParcelEntity transitionParcel(ParcelEntity parcel) throws BLParcelException;
}
