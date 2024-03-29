package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.WarehouseApi;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.exception.BLWarehouseException;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import at.fhtw.swen3.services.mapper.HopMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-18T12:42:11.503113Z[Etc/UTC]")
@Controller
@Slf4j
public class WarehouseApiController implements WarehouseApi {

    private final NativeWebRequest request;
    private final WarehouseService warehouseService;
    private final WarehouseMapper warehouseMapper = WarehouseMapper.INSTANCE;
    private final HopMapper hopMapper = HopMapper.INSTANCE;

    @Autowired
    public WarehouseApiController(NativeWebRequest request, WarehouseServiceImpl warehouseService) {
        this.request = request;
        this.warehouseService = warehouseService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Warehouse> exportWarehouses() throws BLWarehouseException {
        log.info("exportWarehouses called");
        var warehouses = warehouseService.exportWarehouses();
        log.info("Warehouse hierarchy fetched");
        return new ResponseEntity<>(warehouses, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Hop> getWarehouse(@Parameter(name = "code", description = "", required = true) @PathVariable("code") String code) throws BLWarehouseException {
        log.info("getWarehouse called");
        Hop hop = hopMapper.entityToDto(warehouseService.getWarehouse(code));
        log.info("Hop fetched");
        return new ResponseEntity<>(hop, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> importWarehouses(Warehouse warehouse) throws BLWarehouseException {
        log.info("importWarehouses called");
        warehouseService.importWarehouses(warehouse);
        log.info("Warehouse hierarchy imported");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
