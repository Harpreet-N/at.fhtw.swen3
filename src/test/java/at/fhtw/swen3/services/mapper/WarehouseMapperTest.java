package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO: fill list with dummy value and test conversion
public class WarehouseMapperTest {
    @Test
    void mapWarehouseDTOToEntity() {
        Warehouse warehouseDTO = new Warehouse();
        warehouseDTO.level(27);
        warehouseDTO.nextHops(new ArrayList<>());

        WarehouseEntity warehouseEntity = WarehouseMapper.INSTANCE.dtoToEntity(warehouseDTO);

        assertEquals(warehouseDTO.getLevel(), warehouseEntity.getLevel());
        assertEquals(warehouseDTO.getNextHops(), warehouseEntity.getNextHops());
    }

    @Test
    void mapWarehouseEntityToDTO() {
        WarehouseEntity warehouseEntity = new WarehouseEntity(27, new ArrayList<>());

        Warehouse warehouseDTO = WarehouseMapper.INSTANCE.entityToDto(warehouseEntity);

        assertEquals(warehouseDTO.getLevel(), warehouseEntity.getLevel());
        assertEquals(warehouseDTO.getNextHops(), warehouseEntity.getNextHops());
    }
}
