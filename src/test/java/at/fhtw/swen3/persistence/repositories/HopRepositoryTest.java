package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

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
    }

    @Test
    void testSave(){
        GeoCoordinateEntity geoCoordinateEntity = getDummyGeoCoordinateEntity();
        HopEntity hopEntity = HopEntity.builder().hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testSave(hopEntity, hopRepository);
    }

    @Test
    void testFindById() {
        GeoCoordinateEntity geoCoordinateEntity = getDummyGeoCoordinateEntity();
        HopEntity hopEntity = HopEntity.builder().hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testFindById(hopEntity, hopRepository);
    }
    @Test
    void testDelete() {
        GeoCoordinateEntity geoCoordinateEntity = getDummyGeoCoordinateEntity();
        HopEntity hopEntity = HopEntity.builder().hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testDelete(hopEntity, hopRepository);
    }
    @Test
    void testFindAll() {
        GeoCoordinateEntity geoCoordinateEntity1 = getDummyGeoCoordinateEntity();
        GeoCoordinateEntity geoCoordinateEntity2 = getDummyGeoCoordinateEntity();
        HopEntity hopEntity1 = HopEntity.builder().hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity1).build();
        HopEntity hopEntity2 = HopEntity.builder().hopType("abc").code("AAAA2222").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity2).build();
        baseRepositoryTest.testFindAll(hopEntity1, hopEntity2, hopRepository);
    }
    @Test
    void testCount() {
        GeoCoordinateEntity geoCoordinateEntity1 = getDummyGeoCoordinateEntity();
        GeoCoordinateEntity geoCoordinateEntity2 = getDummyGeoCoordinateEntity();
        HopEntity hopEntity1 = HopEntity.builder().hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity1).build();
        HopEntity hopEntity2 = HopEntity.builder().hopType("abc").code("AAAA2222").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity2).build();
        baseRepositoryTest.testCount(hopEntity1, hopEntity2, hopRepository);
    }

    GeoCoordinateEntity getDummyGeoCoordinateEntity() {
        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateEntity.builder().location(getDummyPoint()).build();
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
