package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.services.WarehouseApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WarehouseApiControllerTest {


    @Autowired
    private WarehouseApi warehouseApi;

    @BeforeEach
    void setup(){

    }
/*
    @Test
    void getRequest() {
        var result = warehouseApi.getRequest();
        assertNotNull(result);
    }


 */

}