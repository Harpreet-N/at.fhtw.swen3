package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.services.WarehouseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/application.properties")
public class WarehouseServiceImplTest {
    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseServiceImplTest(WarehouseServiceImpl warehouseService) {
        this.warehouseService = warehouseService;
    }

    @Test
    void emptyTest(){

    }
}
