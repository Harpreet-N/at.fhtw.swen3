package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.AfterTestClass;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestPropertySource("/application.properties")
public class WarehouseRepositoryTest {


    private final WarehouseRepository warehouseRepository;
    private final BaseRepositoryTest baseRepositoryTest;
    private final GeoCoordinateRepository geoCoordinateRepository;

    @Autowired
    public WarehouseRepositoryTest(WarehouseRepository warehouseRepository, GeoCoordinateRepository geoCoordinateRepository) {
        this.warehouseRepository = warehouseRepository;
        this.geoCoordinateRepository = geoCoordinateRepository;
        this.baseRepositoryTest = new BaseRepositoryTest();
    }

    @BeforeEach
    public void beforeEach() {
        warehouseRepository.deleteAll();
    }

    @AfterTestClass
    public void after(){
        warehouseRepository.deleteAll();
        geoCoordinateRepository.deleteAll();
    }

/*
    @Test
    void testDelete() {
        GeoCoordinateEntity geoCoordinateEntity = getDummyGeoCoordinateEntity();
        WarehouseEntity warehouseEntity = WarehouseEntity.builder().level(1).nextHops(new ArrayList<>()).id(1).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testDelete(warehouseEntity, warehouseRepository);
    }

 */

    @Test
    void testFindById() {
        GeoCoordinateEntity geoCoordinateEntity = getDummyGeoCoordinateEntity();
        WarehouseEntity warehouseEntity = WarehouseEntity.builder().level(1).nextHops(new ArrayList<>()).id(1).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testFindById(warehouseEntity, warehouseRepository);
    }

    @Test
    void testSave() {
        GeoCoordinateEntity geoCoordinateEntity = getDummyGeoCoordinateEntity();
        WarehouseEntity warehouseEntity = WarehouseEntity.builder().level(1).nextHops(new ArrayList<>()).id(1).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testSave(warehouseEntity, warehouseRepository);
    }


    @Test
    void testFindAll() {
        GeoCoordinateEntity geoCoordinateEntity = getDummyGeoCoordinateEntity();
        WarehouseEntity warehouseEntity1 = WarehouseEntity.builder().level(1).nextHops(new ArrayList<>()).id(1).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        WarehouseEntity warehouseEntity2 = WarehouseEntity.builder().level(2).nextHops(new ArrayList<>()).id(2).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testFindAll(warehouseEntity1, warehouseEntity2, warehouseRepository);
    }

    GeoCoordinateEntity getDummyGeoCoordinateEntity() {
        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateEntity.builder().id(1).lat(1.0).lon(2.0).build();
        geoCoordinateRepository.save(geoCoordinateEntity);
        return geoCoordinateEntity;
    }

}
