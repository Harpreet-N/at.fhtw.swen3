package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.ApiUtil;
import at.fhtw.swen3.controller.WarehouseApi;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public ResponseEntity<Warehouse> exportWarehouses() {
        WarehouseEntity warehouseEntity = warehouseService.exportWarehouses().get();
        log.info("exportWarehouses called");
        Warehouse warehouse = warehouseMapper.entityToDto(warehouseEntity);
        return new ResponseEntity<>(warehouse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Hop> getWarehouse(@Parameter(name = "code", description = "", required = true) @PathVariable("code") String code) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : \"code\", \"locationName\" : \"locationName\", \"processingDelayMins\" : 0, \"hopType\" : \"hopType\", \"description\" : \"description\", \"locationCoordinates\" : { \"lon\" : 1.4658129805029452, \"lat\" : 6.027456183070403 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        warehouseService.getWarehouse(code);
        log.info("getWarehouse called");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> importWarehouses(@Parameter(name = "Warehouse", description = "", required = true) @Valid @RequestBody Warehouse warehouse) {
        WarehouseEntity warehouseEntity = warehouseMapper.dtoToEntity(warehouse);
        warehouseService.importWarehouses(warehouseEntity);
        log.info("Warehouse hierarchy imported");
        log.info("Warehouse: {}", warehouseEntity.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
