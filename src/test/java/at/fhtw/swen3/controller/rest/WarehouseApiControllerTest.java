package at.fhtw.swen3.controller.rest;

import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import javax.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource("/application.properties")
class WarehouseApiControllerTest {

    private final WarehouseApiController warehouseApiController;

    @Autowired
    WarehouseApiControllerTest(WarehouseApiController warehouseApiController) {
        this.warehouseApiController = warehouseApiController;
    }

    @Test
    void testExportWarehouseValid() {
        ResponseEntity<Warehouse> response = warehouseApiController.exportWarehouses();

        assertNotEquals(response, null);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    //TODO: Change 200 TO 400 when Service gets implemented
    @Test
    void testExportWarehouseInvalid() {
        ResponseEntity<Warehouse> response = warehouseApiController.exportWarehouses();

        assertNotEquals(response, null);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void testGetWarehouseValid() {
        ResponseEntity<Hop> response = warehouseApiController.getWarehouse("ABCD1234");

        assertNotEquals(response, null);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    //TODO: Change 200 TO 400 when Service gets implemented
    @Test
    void testGetWarehouseInvalid() {
        ResponseEntity<Hop> response = warehouseApiController.getWarehouse("ABCD1234");

        assertNotEquals(response, null);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void testImportWarehouseValid() {
        Warehouse warehouseDto = createDummyWarehouse();
        ResponseEntity<Void> response = warehouseApiController.importWarehouses(warehouseDto);

        assertNotEquals(response, null);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    void testImportWarehouseInvalid() {
        Warehouse warehouseDto = createDummyWarehouse();
        warehouseDto.setNextHops(null);

        assertThrows(ValidationException.class, ()->{warehouseApiController.importWarehouses(warehouseDto);});
    }

    private Warehouse createDummyWarehouse() {
        GeoCoordinate geoCoordinate = new GeoCoordinate().lat(1.0).lon(1.0);
        Hop hop = new Hop().code("ABCD1234").description("a").hopType("b").locationName("c").processingDelayMins(1).locationCoordinates(geoCoordinate);
        WarehouseNextHops warehouseNextHops = new WarehouseNextHops().hop(hop).traveltimeMins(1);
        return new Warehouse().level(1).code("ABCD1234").description("a").hopType("b").locationName("c").processingDelayMins(1).locationCoordinates(geoCoordinate).addNextHopsItem(warehouseNextHops);
    }
}