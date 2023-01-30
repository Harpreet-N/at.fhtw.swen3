package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.AfterTestClass;

@SpringBootTest
@TestPropertySource("/application.properties")
public class TruckRepositoryTest {
    private final TruckRepository truckRepository;
    private final BaseRepositoryTest baseRepositoryTest;
    private final GeoCoordinateRepository geoCoordinateRepository;
    private GeoCoordinateEntity geoCoordinateEntity;

    @Autowired
    public TruckRepositoryTest(TruckRepository truckRepository, GeoCoordinateRepository geoCoordinateRepository) {
        this.truckRepository = truckRepository;
        this.geoCoordinateRepository = geoCoordinateRepository;
        this.baseRepositoryTest = new BaseRepositoryTest();
    }

    @BeforeEach
    public void beforeEach() {
        truckRepository.deleteAll();
    }

    @AfterTestClass
    public void after(){
        truckRepository.deleteAll();
        geoCoordinateRepository.deleteAll();
    }


    @Test
    void testSave() {
        TruckEntity truckEntity = TruckEntity.builder().regionGeoJson("region").numberPlate("number").id(1).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testSave(truckEntity, truckRepository);
    }

    @Test
    void testFindById() {
        TruckEntity truckEntity = TruckEntity.builder().regionGeoJson("region").numberPlate("number").id(1).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testFindById(truckEntity, truckRepository);
    }

    @Test
    void testDelete() {
        TruckEntity truckEntity = TruckEntity.builder().regionGeoJson("region").numberPlate("number").id(1).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testDelete(truckEntity, truckRepository);
    }

    @Test
    void testFindAll() {
        TruckEntity truckEntity1 = TruckEntity.builder().regionGeoJson("region").numberPlate("number").id(1).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        TruckEntity truckEntity2 = TruckEntity.builder().regionGeoJson("regions").numberPlate("numbers").id(2).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testFindAll(truckEntity1, truckEntity2, truckRepository);
    }

    @Test
    void testCount() {
        TruckEntity truckEntity1 = TruckEntity.builder().regionGeoJson("region").numberPlate("number").id(1).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        TruckEntity truckEntity2 = TruckEntity.builder().regionGeoJson("regions").numberPlate("numbers").id(1).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testCount(truckEntity1, truckEntity2, truckRepository);
    }

    GeoCoordinateEntity getDummyGeoCoordinateEntity() {
        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateEntity.builder().id(1).lat(1.0).lon(2.0).build();
        geoCoordinateRepository.save(geoCoordinateEntity);
        return geoCoordinateEntity;
    }
}
