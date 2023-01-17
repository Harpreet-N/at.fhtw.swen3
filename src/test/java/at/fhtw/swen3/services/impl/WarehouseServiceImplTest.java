package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.WarehouseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.Optional;

import static at.fhtw.swen3.services.dto.TrackingInformation.StateEnum.INTRANSPORT;
import static at.fhtw.swen3.services.dto.TrackingInformation.StateEnum.PICKUP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class WarehouseServiceImplTest {
    @Mock
    private WarehouseService warehouseService;

    @Mock
    private WarehouseRepository warehouseRepository;

    @Mock
    private WarehouseNextHopsRepository warehouseNextHopsRepository;

    @Mock
    private HopRepository hopRepository;

    @Mock
    private GeoCoordinateRepository geoCoordinateRepository;

    @Mock
    private WarehouseServiceImpl warehouseServiceImpl;

    final String trackingId = "trackingId";
    final String visitedHops = "visitedHops";
    final String futureHops = "futureHops";
    final String futureHop = "futureHop";

    @BeforeEach
    void setUp() {
        warehouseRepository = mock(WarehouseRepository.class);
        hopRepository = mock(HopRepository.class);
        warehouseNextHopsRepository = mock(WarehouseNextHopsRepository.class);
        geoCoordinateRepository = mock(GeoCoordinateRepository.class);

        warehouseServiceImpl = new WarehouseServiceImpl(warehouseRepository, warehouseNextHopsRepository, hopRepository, geoCoordinateRepository);
    }

    @Test
    void gerWarehouseTest() {
        WarehouseEntity warehouseEntity1 = buildWarehouse(10);

        doReturn(warehouseEntity1).when(warehouseRepository).findByTrackingId(10);

        when(warehouseRepository.findByTrackingId(10)).thenReturn(warehouseEntity1);

        warehouseService.importWarehouses(warehouseEntity1);

        Optional<WarehouseEntity> reportParcelHop = warehouseService.exportWarehouses();

       // assertThat(reportParcelHop.get().getId()).isEqualTo(warehouseEntity1.getId());
    }


    private WarehouseEntity buildWarehouse(int id) {
        return WarehouseEntity.builder().id(id).level(1).nextHops(new ArrayList<>()).build();
    }
}
