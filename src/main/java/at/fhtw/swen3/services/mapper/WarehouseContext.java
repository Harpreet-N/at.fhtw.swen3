package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;

public class WarehouseContext {

    private WarehouseEntity warehouse;

    @BeforeMapping
    public void setEntity(@MappingTarget WarehouseEntity warehouse) {
        this.warehouse = warehouse;
    }

    @AfterMapping
    public void setWarehouseNextHopsEntity(@MappingTarget WarehouseNextHopsEntity warehouseNextHopsEntity) {
        warehouseNextHopsEntity.setWarehouse(warehouse);
    }
}
