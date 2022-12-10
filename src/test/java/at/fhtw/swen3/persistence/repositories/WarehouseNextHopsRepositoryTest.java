package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/application.properties")
public class WarehouseNextHopsRepositoryTest {

    private final WarehouseNextHopsRepository warehouseNextHopsRepository;
    private final HopRepository hopRepository;
    private final GeoCoordinateRepository geoCoordinateRepository;
    private final BaseRepositoryTest baseRepositoryTest;

    @Autowired
    public WarehouseNextHopsRepositoryTest(WarehouseNextHopsRepository warehouseNextHopsRepository, HopRepository hopRepository, GeoCoordinateRepository geoCoordinateRepository) {
        this.warehouseNextHopsRepository = warehouseNextHopsRepository;
        this.hopRepository = hopRepository;
        this.geoCoordinateRepository = geoCoordinateRepository;
        this.baseRepositoryTest = new BaseRepositoryTest();
    }

    @BeforeEach
    public void beforeEach() {
        warehouseNextHopsRepository.deleteAll();
    }

    @Test
    void testSave() {
        HopEntity hopEntity = getDummyHopEntity();
        WarehouseNextHopsEntity warehouseNextHopsEntity = WarehouseNextHopsEntity.builder().traveltimeMins(1).hop(getDummyHopEntity()).build();
        baseRepositoryTest.testSave(warehouseNextHopsEntity, warehouseNextHopsRepository);
    }

    @Test
    void testFindById() {
        HopEntity hopEntity = getDummyHopEntity();
        WarehouseNextHopsEntity warehouseNextHopsEntity = WarehouseNextHopsEntity.builder().traveltimeMins(1).hop(getDummyHopEntity()).build();
        baseRepositoryTest.testFindById(warehouseNextHopsEntity, warehouseNextHopsRepository);
    }

    @Test
    void testDelete() {
        HopEntity hopEntity = getDummyHopEntity();
        WarehouseNextHopsEntity warehouseNextHopsEntity = WarehouseNextHopsEntity.builder().traveltimeMins(1).hop(getDummyHopEntity()).build();
        baseRepositoryTest.testDelete(warehouseNextHopsEntity, warehouseNextHopsRepository);
    }

    @Test
    void testFindAll() {
        HopEntity hopEntity = getDummyHopEntity();
        WarehouseNextHopsEntity warehouseNextHopsEntity1 = WarehouseNextHopsEntity.builder().traveltimeMins(1).hop(getDummyHopEntity()).build();
        WarehouseNextHopsEntity warehouseNextHopsEntity2 = WarehouseNextHopsEntity.builder().traveltimeMins(1).hop(getDummyHopEntity()).build();
        baseRepositoryTest.testFindAll(warehouseNextHopsEntity1, warehouseNextHopsEntity2, warehouseNextHopsRepository);
    }

    @Test
    void testCount() {
        HopEntity hopEntity = getDummyHopEntity();
        WarehouseNextHopsEntity warehouseNextHopsEntity1 = WarehouseNextHopsEntity.builder().traveltimeMins(1).hop(getDummyHopEntity()).build();
        WarehouseNextHopsEntity warehouseNextHopsEntity2 = WarehouseNextHopsEntity.builder().traveltimeMins(1).hop(getDummyHopEntity()).build();
        baseRepositoryTest.testCount(warehouseNextHopsEntity1, warehouseNextHopsEntity2, warehouseNextHopsRepository);
    }

    HopEntity getDummyHopEntity() {
        GeoCoordinateEntity geoCoordinateEntity = getDummyGeoCoordinateEntity();
        HopEntity hopEntity = HopEntity.builder().hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        hopRepository.save(hopEntity);
        return hopEntity;
    }

    GeoCoordinateEntity getDummyGeoCoordinateEntity() {
        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateEntity.builder().lat(1.0).lon(1.0).build();
        geoCoordinateRepository.save(geoCoordinateEntity);
        return geoCoordinateEntity;
    }

}
