package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/application.properties")
public class TruckRepositoryTest {
    private final TruckRepository truckRepository;
    private final BaseRepositoryTest baseRepositoryTest;

    @Autowired
    public TruckRepositoryTest(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
        this.baseRepositoryTest = new BaseRepositoryTest();
    }

    @BeforeEach
    public void beforeEach() {
        truckRepository.deleteAll();
    }

    @Test
    void testSave() {
        TruckEntity truckEntity = TruckEntity.builder().regionGeoJson("region").numberPlate("number").build();
        baseRepositoryTest.testSave(truckEntity, truckRepository);
    }

    @Test
    void testFindById() {
        TruckEntity truckEntity = TruckEntity.builder().regionGeoJson("region").numberPlate("number").build();
        baseRepositoryTest.testFindById(truckEntity, truckRepository);
    }

    @Test
    void testDelete() {
        TruckEntity truckEntity = TruckEntity.builder().regionGeoJson("region").numberPlate("number").build();
        baseRepositoryTest.testDelete(truckEntity, truckRepository);
    }

    @Test
    void testFindAll() {
        TruckEntity truckEntity1 = TruckEntity.builder().regionGeoJson("region").numberPlate("number").build();
        TruckEntity truckEntity2 = TruckEntity.builder().regionGeoJson("regions").numberPlate("numbers").build();
        baseRepositoryTest.testFindAll(truckEntity1, truckEntity2, truckRepository);
    }

    @Test
    void testCount() {
        TruckEntity truckEntity1 = TruckEntity.builder().regionGeoJson("region").numberPlate("number").build();
        TruckEntity truckEntity2 = TruckEntity.builder().regionGeoJson("regions").numberPlate("numbers").build();
        baseRepositoryTest.testCount(truckEntity1, truckEntity2, truckRepository);
    }

}
