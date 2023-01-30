package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.AfterTestClass;

@SpringBootTest
@TestPropertySource("/application.properties")
public class TransferwarehouseRepositoryTest {

    private final TransferwarehouseRepository transferwarehouseRepository;
    private final BaseRepositoryTest baseRepositoryTest;
    private final GeoCoordinateRepository geoCoordinateRepository;
    private GeoCoordinateEntity geoCoordinateEntity;

    @Autowired
    public TransferwarehouseRepositoryTest(TransferwarehouseRepository transferwarehouseRepository, GeoCoordinateRepository geoCoordinateRepository) {
        this.transferwarehouseRepository = transferwarehouseRepository;
        this.baseRepositoryTest = new BaseRepositoryTest();
        this.geoCoordinateRepository = geoCoordinateRepository;

    }

    @BeforeEach
    public void beforeEach() {
        transferwarehouseRepository.deleteAll();
        geoCoordinateRepository.deleteAll();
    }

    @AfterTestClass
    public void after(){
        transferwarehouseRepository.deleteAll();
        geoCoordinateRepository.deleteAll();
    }


    @Test
    void testSave() {
        TransferwarehouseEntity transferwarehouseEntity = TransferwarehouseEntity.builder().regionGeoJson("a").logisticsPartner("b").logisticsPartnerUrl("c").id(1).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testSave(transferwarehouseEntity, transferwarehouseRepository);
    }

    @Test
    void testFindById() {
        TransferwarehouseEntity transferwarehouseEntity = TransferwarehouseEntity.builder().regionGeoJson("a").logisticsPartner("b").logisticsPartnerUrl("c").id(2).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testFindById(transferwarehouseEntity, transferwarehouseRepository);
    }

    @Test
    void testDelete() {
        TransferwarehouseEntity transferwarehouseEntity = TransferwarehouseEntity.builder().regionGeoJson("a").logisticsPartner("b").logisticsPartnerUrl("c").id(3).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testDelete(transferwarehouseEntity, transferwarehouseRepository);
    }

    @Test
    void testFindAll() {
        TransferwarehouseEntity transferwarehouseEntity1 = TransferwarehouseEntity.builder().regionGeoJson("a").logisticsPartner("b").logisticsPartnerUrl("c").id(4).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        TransferwarehouseEntity transferwarehouseEntity2 = TransferwarehouseEntity.builder().regionGeoJson("d").logisticsPartner("e").logisticsPartnerUrl("f").id(5).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testFindAll(transferwarehouseEntity1, transferwarehouseEntity2, transferwarehouseRepository);
    }

    @Test
    void testCount() {
        TransferwarehouseEntity transferwarehouseEntity1 = TransferwarehouseEntity.builder().regionGeoJson("a").logisticsPartner("b").logisticsPartnerUrl("c").id(6).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        TransferwarehouseEntity transferwarehouseEntity2 = TransferwarehouseEntity.builder().regionGeoJson("d").logisticsPartner("e").logisticsPartnerUrl("f").id(7).hopType("abc").code("AAAA1111").description("abc").processingDelayMins(1).locationName("abc").locationCoordinates(geoCoordinateEntity).build();
        baseRepositoryTest.testCount(transferwarehouseEntity1, transferwarehouseEntity2, transferwarehouseRepository);
    }
}
