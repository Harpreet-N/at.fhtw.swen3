package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.TrackingInformation;
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
    public ParcelEntity reportParcelDelivery(String trackingId) {
        ParcelEntity parcel = parcelRepository.findByTrackingId(trackingId);
        parcel.setState(TrackingInformation.StateEnum.DELIVERED);
        parcelRepository.save(parcel);
        return parcel;
    }

    @Override
    public ParcelEntity reportParcelHop(String trackingId, String code) {
        ParcelEntity parcel = parcelRepository.findByTrackingId(trackingId);
        HopEntity hop = hopRepository.findByCode(code);
        switch (hop.getHopType()) {
            case "Warehouse" -> parcel.setState(TrackingInformation.StateEnum.INTRANSPORT);
            case "Truck" -> parcel.setState(TrackingInformation.StateEnum.INTRUCKDELIVERY);
            case "TransferWarehouse" -> parcel.setState(TrackingInformation.StateEnum.TRANSFERRED);
        }
        HopArrivalEntity visitedHop = (HopArrivalEntity) parcel.getFutureHops().stream().filter(hopArrivalEntity -> hopArrivalEntity.getCode().equals(code));
        parcel.getVisitedHops().add(visitedHop);
        parcel.getFutureHops().remove(0);
        parcelRepository.save(parcel);
        return parcel;
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
