package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.exception.bl.BLPracelException;
import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;

    private final HopRepository hopRepository;

    private final GeoEncodingService geoEncodingService;

    @Override
    public ParcelEntity reportParcelDelivery(String trackingId) {
        ParcelEntity parcel = parcelRepository.findByTrackingId(trackingId);
        parcel.setState(TrackingInformation.StateEnum.DELIVERED);
        parcelRepository.save(parcel);
        return parcel;
    }

    @Override
    public ParcelEntity reportParcelHop(String trackingId, String code)  {
        ParcelEntity parcel = parcelRepository.findByTrackingId(trackingId);
        if (parcel != null) {
            validateFirstInFutureHops(parcel, code);
            hopToArrivalToVisited(parcel);
            setReportHopTrackingState(parcel, code);
            parcelRepository.save(parcel);
            return parcel;
        }
        log.info("Parcel not found {}", trackingId);
        throw new BLPracelException(trackingId);
    }

    private void validateFirstInFutureHops(ParcelEntity parcel, String code) {
        HopArrivalEntity hopArrival = findFirstFutureHop(parcel);
        if (hopArrival == null || !code.equals(hopArrival.getCode())) {
            throw new BLPracelException(code);
        }
    }

    private void hopToArrivalToVisited(ParcelEntity parcel) {
        HopArrivalEntity hopArrival = findFirstFutureHop(parcel);
        if (hopArrival != null) {
            parcel.getFutureHops().remove(hopArrival);
            parcel.getVisitedHops().add(hopArrival);
        }
    }

    private void setReportHopTrackingState(ParcelEntity parcel, String code) {
        if (parcel.getFutureHops().isEmpty() && code.equals(getLastElement(parcel.getVisitedHops()).getCode())) {
            parcel.setState(TrackingInformation.StateEnum.INTRUCKDELIVERY);
        } else {
            parcel.setState(TrackingInformation.StateEnum.INTRANSPORT);
        }
    }

    private <T> T getLastElement(List<T> list) {
        return list.get(list.size() - 1);
    }

    private HopArrivalEntity findFirstFutureHop(ParcelEntity parcel) {
        for (HopArrivalEntity hopArrivalEntity : parcel.getFutureHops()) {
            return hopArrivalEntity;
        }
        return null;
    }



    @Override
    public String submitParcel(ParcelEntity parcel) {
        parcel.setState(TrackingInformation.StateEnum.PICKUP);
        parcelRepository.save(parcel);
        log.info(parcel.getTrackingId());
        return parcel.getTrackingId();
    }

    @Override
    public ParcelEntity trackParcel(String trackingId) {
        return parcelRepository.findByTrackingId(trackingId);
    }

    @Override
    public ParcelEntity transferParcel(ParcelEntity parcel) {
        parcelRepository.save(parcel);
        return parcel;
    }
}
