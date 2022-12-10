package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/application.properties")
public class TransferwarehouseRepositoryTest {

    private final TransferwarehouseRepository transferwarehouseRepository;
    private final BaseRepositoryTest baseRepositoryTest;

    @Autowired
    public TransferwarehouseRepositoryTest(TransferwarehouseRepository transferwarehouseRepository) {
        this.transferwarehouseRepository = transferwarehouseRepository;
        this.baseRepositoryTest = new BaseRepositoryTest();
    }

    @BeforeEach
    public void beforeEach() {
        transferwarehouseRepository.deleteAll();
    }

    @Test
    void testSave() {
        TransferwarehouseEntity transferwarehouseEntity = TransferwarehouseEntity.builder().regionGeoJson("a").logisticsPartner("b").logisticsPartnerUrl("c").build();
        baseRepositoryTest.testSave(transferwarehouseEntity, transferwarehouseRepository);
    }

    @Test
    void testFindById() {
        TransferwarehouseEntity transferwarehouseEntity = TransferwarehouseEntity.builder().regionGeoJson("a").logisticsPartner("b").logisticsPartnerUrl("c").build();
        baseRepositoryTest.testFindById(transferwarehouseEntity, transferwarehouseRepository);
    }

    @Test
    void testDelete() {
        TransferwarehouseEntity transferwarehouseEntity = TransferwarehouseEntity.builder().regionGeoJson("a").logisticsPartner("b").logisticsPartnerUrl("c").build();
        baseRepositoryTest.testDelete(transferwarehouseEntity, transferwarehouseRepository);
    }

    @Test
    void testFindAll() {
        TransferwarehouseEntity transferwarehouseEntity1 = TransferwarehouseEntity.builder().regionGeoJson("a").logisticsPartner("b").logisticsPartnerUrl("c").build();
        TransferwarehouseEntity transferwarehouseEntity2 = TransferwarehouseEntity.builder().regionGeoJson("d").logisticsPartner("e").logisticsPartnerUrl("f").build();
        baseRepositoryTest.testFindAll(transferwarehouseEntity1, transferwarehouseEntity2, transferwarehouseRepository);
    }

    @Test
    void testCount() {
        TransferwarehouseEntity transferwarehouseEntity1 = TransferwarehouseEntity.builder().regionGeoJson("a").logisticsPartner("b").logisticsPartnerUrl("c").build();
        TransferwarehouseEntity transferwarehouseEntity2 = TransferwarehouseEntity.builder().regionGeoJson("d").logisticsPartner("e").logisticsPartnerUrl("f").build();
        baseRepositoryTest.testCount(transferwarehouseEntity1, transferwarehouseEntity2, transferwarehouseRepository);
    }
}
