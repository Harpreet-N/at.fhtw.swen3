package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.gps.service.models.GeoCoordinate;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.TruckRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseNextHopsRepository;
import at.fhtw.swen3.services.exception.BLParcelException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static at.fhtw.swen3.services.dto.TrackingInformation.StateEnum.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ParcelServiceImplTest {

    @Mock
    private ParcelServiceImpl parcelService;

    @Mock
    private ParcelRepository parcelRepository;
    @Mock
    private HopRepository hopRepository;
    @Mock
    private WarehouseNextHopsRepository warehouseNextHopsRepository;
    @Mock
    private GeoEncodingService geoEncodingService;
    @Mock
    private TruckRepository truckRepository;


    final String trackingId = "trackingId";
    final String visitedHops = "visitedHops";
    final String futureHops = "futureHops";
    final String futureHop = "futureHop";

    @BeforeEach
    void setUp() {
        parcelRepository = mock(ParcelRepository.class);
        hopRepository = mock(HopRepository.class);
        warehouseNextHopsRepository = mock(WarehouseNextHopsRepository.class);
        geoEncodingService = mock(GeoEncodingService.class);
        truckRepository = mock(TruckRepository.class);

        parcelService = new ParcelServiceImpl(parcelRepository, hopRepository, geoEncodingService);
    }

    @Test
    void reportParcelHopTest() throws BLParcelException {
        ParcelEntity parcel = buildParcel(trackingId);
        parcel.setVisitedHops(buildHop(visitedHops));
        parcel.setFutureHops(buildHop(futureHops, futureHop));

        when(parcelRepository.findByTrackingId(trackingId)).thenReturn(parcel);

        ParcelEntity reportParcelHop = parcelService.reportParcelHop(trackingId, futureHops);

        assertThat(reportParcelHop.getVisitedHops()).isEqualTo(buildHop(visitedHops, futureHops));
        assertThat(reportParcelHop.getFutureHops()).isEqualTo(buildHop(futureHop));
        assertThat(reportParcelHop.getState()).isEqualTo(INTRANSPORT);
    }

    @Test
    void reportParcelTrucklHopTest() throws BLParcelException {
        final String truckHopCode = "lastTruck";
        ParcelEntity parcel = buildParcel("trackingId");
        parcel.setVisitedHops(buildHop(visitedHops));
        parcel.setFutureHops(buildHop(truckHopCode));

        when(parcelRepository.findByTrackingId(trackingId)).thenReturn(parcel);

        ParcelEntity reportParcelHop = parcelService.reportParcelHop(trackingId, truckHopCode);

        assertThat(reportParcelHop.getState()).isEqualTo(INTRUCKDELIVERY);
    }

    private ParcelEntity buildParcel(String trakcingId) {
        return ParcelEntity.builder()
                .state(PICKUP)
                .trackingId(trakcingId)
                .weight(1.2f)
                .recipient(buildRecipient())
                .sender(buildSender())
                .build();
    }

    private RecipientEntity buildRecipient() {
        return RecipientEntity.builder().name("Name").city("Vienna").street("Strasse")
                .postalCode("A-1150").country("Austria").build();
    }

    private RecipientEntity buildSender() {
        return RecipientEntity.builder().name("Anton").city("City").street("Sender Strasse")
                .postalCode("A-1150").country("Austria").build();
    }

    private List<HopArrivalEntity> buildHop(String... codes) {
        List<HopArrivalEntity> hopArrivalEntities = new ArrayList<>();
        for (String code : codes) {
            HopArrivalEntity hopArrivalEntity = HopArrivalEntity.builder().code(code).build();
            hopArrivalEntities.add(hopArrivalEntity);
        }
        return hopArrivalEntities;
    }

    private GeoCoordinate buildRecipientGeo() {
        return GeoCoordinate.builder().lat("10").lon("20").build();
    }

    private GeoCoordinate buildSenderGeo() {
        return GeoCoordinate.builder().lat("20").lon("20").build();
    }

}
