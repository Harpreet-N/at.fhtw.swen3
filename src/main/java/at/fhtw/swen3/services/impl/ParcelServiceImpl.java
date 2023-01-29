package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.exception.BLParcelException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;
    private final HopRepository hopRepository;
    private final GeoEncodingService geoEncodingService;

    @Override
    public ParcelEntity reportParcelDelivery(String trackingId) throws BLParcelException {
        ParcelEntity parcel;
        try {
            parcel = parcelRepository.findByTrackingId(trackingId);
            parcel.setState(TrackingInformation.StateEnum.DELIVERED);
            parcelRepository.save(parcel);
        } catch (Exception e) {
            log.error("reportParcelDelivery failed! Reason: {}", e.getMessage());
            throw new BLParcelException("reportParcelDelivery failed");
        }
        log.info("reportParcelDelivery successful");
        return parcel;
    }

    @Override
    public ParcelEntity reportParcelHop(String trackingId, String code) throws BLParcelException {
        ParcelEntity parcel = parcelRepository.findByTrackingId(trackingId);
        if (parcel != null) {
            HopArrivalEntity hopArrival = parcel.getFutureHops().get(0);
            if (hopArrival == null || !code.equals(hopArrival.getCode())) {
                log.error("reportParcelHop failed! Reason: No future hops found");
                throw new BLParcelException("No future hops found");
            }

            parcel.getFutureHops().remove(hopArrival);
            parcel.getVisitedHops().add(hopArrival);

            if (parcel.getFutureHops().isEmpty() && code.equals(parcel.getVisitedHops().get(parcel.getVisitedHops().size() - 1).getCode())) {
                parcel.setState(TrackingInformation.StateEnum.INTRUCKDELIVERY);
            } else {
                parcel.setState(TrackingInformation.StateEnum.INTRANSPORT);
            }

            parcelRepository.save(parcel);
            log.info("reportParcelHop successful");
            return parcel;
        }
        log.error("reportParcelHop failed! Reason: Parcel not found");
        throw new BLParcelException("Parcel not found");
    }

    @Override
    public String submitParcel(ParcelEntity parcel) throws BLParcelException {
        try {
            parcel.setState(TrackingInformation.StateEnum.PICKUP);
            parcelRepository.save(parcel);
            log.info(parcel.getTrackingId());
        } catch (Exception e) {
            log.error("submitParcel failed! Reason: {}", e.getMessage());
            throw new BLParcelException("submitParcel failed");
        }
        log.info("submitParcel successful");
        return parcel.getTrackingId();
    }

    @Override
    public ParcelEntity transitionParcel(ParcelEntity parcel) throws BLParcelException {
        try {
            parcelRepository.save(parcel);
        } catch (Exception e) {
            log.error("transitionParcel failed! Reason: {}", e.getMessage());
            throw new BLParcelException("transitionParcel failed");
        }
        log.info("transitionParcel successful");
        return parcel;
    }

    @Override
    public ParcelEntity trackParcel(String trackingId) throws BLParcelException {
        ParcelEntity parcel;
        try {
            parcel = parcelRepository.findByTrackingId(trackingId);
        } catch (Exception e) {
            log.error("trackParcel failed! Reason: {}", e.getMessage());
            throw new BLParcelException("trackParcel failed");
        }
        log.info("trackParcel successful");
        return parcel;
    }

}
