package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;

@SpringBootTest
@TestPropertySource("/application.properties")
public class WarehouseRepositoryTest {


    private final WarehouseRepository warehouseRepository;
    private final BaseRepositoryTest baseRepositoryTest;

    @Autowired
    public WarehouseRepositoryTest(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
        this.baseRepositoryTest = new BaseRepositoryTest();
    }

    @BeforeEach
    public void beforeEach() {
        warehouseRepository.deleteAll();
    }

    @Test
    void testSave() {
        WarehouseEntity warehouseEntity = WarehouseEntity.builder().level(1).nextHops(new ArrayList<>()).build();
        baseRepositoryTest.testSave(warehouseEntity, warehouseRepository);
    }

    @Test
    void testFindById() {
        WarehouseEntity warehouseEntity = WarehouseEntity.builder().level(1).nextHops(new ArrayList<>()).build();
        baseRepositoryTest.testFindById(warehouseEntity, warehouseRepository);
    }

    @Test
    void testDelete() {
        WarehouseEntity warehouseEntity = WarehouseEntity.builder().level(1).nextHops(new ArrayList<>()).build();
        baseRepositoryTest.testDelete(warehouseEntity, warehouseRepository);
    }

    @Test
    void testFindAll() {
        WarehouseEntity warehouseEntity1 = WarehouseEntity.builder().level(1).nextHops(new ArrayList<>()).build();
        WarehouseEntity warehouseEntity2 = WarehouseEntity.builder().level(2).nextHops(new ArrayList<>()).build();
        baseRepositoryTest.testFindAll(warehouseEntity1, warehouseEntity2, warehouseRepository);
    }

    @Test
    void testCount() {
        WarehouseEntity warehouseEntity1 = WarehouseEntity.builder().level(1).nextHops(new ArrayList<>()).build();
        WarehouseEntity warehouseEntity2 = WarehouseEntity.builder().level(2).nextHops(new ArrayList<>()).build();
        baseRepositoryTest.testCount(warehouseEntity1, warehouseEntity2, warehouseRepository);
    }

}
