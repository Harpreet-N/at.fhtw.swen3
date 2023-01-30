package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.AfterTestClass;

import java.util.Locale;

@SpringBootTest
@TestPropertySource("/application.properties")
class HopRepositoryTest {
    private final HopRepository hopRepository;
    private final GeoCoordinateRepository geoCoordinateRepository;
    private final BaseRepositoryTest baseRepositoryTest;

    @Autowired
    public HopRepositoryTest(HopRepository hopRepository, GeoCoordinateRepository geoCoordinateRepository) {
        this.hopRepository = hopRepository;
        this.geoCoordinateRepository = geoCoordinateRepository;
        this.baseRepositoryTest = new BaseRepositoryTest();
    }

    @BeforeEach
    public void beforeEach(){
        hopRepository.deleteAll();
        geoCoordinateRepository.deleteAll();
    }

    @AfterTestClass
    public void after(){
        hopRepository.deleteAll();
        geoCoordinateRepository.deleteAll();
    }

    @Test
    void testSave(){
        GeoCoordinateEntity geoCoordinateEntity = getDummyGeoCoordinateEntity();
        HopEntity hopEntity = HopEntity.builder().hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).id(1).build();
        baseRepositoryTest.testSave(hopEntity, hopRepository);
    }

    @Test
    void testFindById() {
        GeoCoordinateEntity geoCoordinateEntity = getDummyGeoCoordinateEntity();
        HopEntity hopEntity = HopEntity.builder().hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).id(1).build();
        baseRepositoryTest.testFindById(hopEntity, hopRepository);
    }
    @Test
    void testDelete() {
        GeoCoordinateEntity geoCoordinateEntity = getDummyGeoCoordinateEntity();
        HopEntity hopEntity = HopEntity.builder().hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).id(1).build();
        baseRepositoryTest.testDelete(hopEntity, hopRepository);
    }
    @Test
    void testFindAll() {
        GeoCoordinateEntity geoCoordinateEntity1 = getDummyGeoCoordinateEntity();
        GeoCoordinateEntity geoCoordinateEntity2 = getDummyGeoCoordinateEntitySecond();
        HopEntity hopEntity1 = HopEntity.builder().hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity1).id(1).build();
        HopEntity hopEntity2 = HopEntity.builder().hopType("abc").code("AAAA2222").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity2).id(2).build();
        baseRepositoryTest.testFindAll(hopEntity1, hopEntity2, hopRepository);
    }
    @Test
    void testCount() {
        GeoCoordinateEntity geoCoordinateEntity1 = getDummyGeoCoordinateEntity();
        GeoCoordinateEntity geoCoordinateEntity2 = getDummyGeoCoordinateEntitySecond();
        HopEntity hopEntity1 = HopEntity.builder().hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity1).id(1).build();
        HopEntity hopEntity2 = HopEntity.builder().hopType("abc").code("AAAA2222").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity2).id(2).build();
        baseRepositoryTest.testCount(hopEntity1, hopEntity2, hopRepository);
    }

    GeoCoordinateEntity getDummyGeoCoordinateEntity() {
        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateEntity.builder().id(1).lat(1.0).lon(2.0).build();
        geoCoordinateRepository.save(geoCoordinateEntity);
        return geoCoordinateEntity;
    }

    GeoCoordinateEntity getDummyGeoCoordinateEntitySecond() {
        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateEntity.builder().id(2).lat(1.0).lon(2.0).build();
        geoCoordinateRepository.save(geoCoordinateEntity);
        return geoCoordinateEntity;
    }

    Point getDummyPoint() {
        try {
            String wktPoint = String.format(Locale.US, "POINT(%f %f)", 1.0, 1.0);
            Point point = (Point) new WKTReader().read(wktPoint);
            return point;
        } catch (Exception e) {
            return null;
        }
    }
}
