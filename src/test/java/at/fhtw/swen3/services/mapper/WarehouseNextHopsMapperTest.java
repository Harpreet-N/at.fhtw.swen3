package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarehouseNextHopsMapperTest {
    @Test
    void mapWarehouseNextHopsDTOToEntity() {
        WarehouseNextHops warehouseNextHopsDTO = new WarehouseNextHops();
        warehouseNextHopsDTO.traveltimeMins(27);
        warehouseNextHopsDTO.hop(new Hop());

        WarehouseNextHopsEntity warehouseNextHopsEntity = WarehouseNextHopsMapper.INSTANCE.dtoToEntity(warehouseNextHopsDTO);

        assertEquals(warehouseNextHopsDTO.getTraveltimeMins(), warehouseNextHopsEntity.getTraveltimeMins());
        assertEquals(warehouseNextHopsDTO.getHop().getHopType(), warehouseNextHopsEntity.getHop().getHopType());
        assertEquals(warehouseNextHopsDTO.getHop().getCode(), warehouseNextHopsEntity.getHop().getCode());
        assertEquals(warehouseNextHopsDTO.getHop().getDescription(), warehouseNextHopsEntity.getHop().getDescription());
        assertEquals(warehouseNextHopsDTO.getHop().getProcessingDelayMins(), warehouseNextHopsEntity.getHop().getProcessingDelayMins());
        assertEquals(warehouseNextHopsDTO.getHop().getLocationName(), warehouseNextHopsEntity.getHop().getLocationName());
        assertEquals(warehouseNextHopsDTO.getHop().getLocationCoordinates(), warehouseNextHopsEntity.getHop().getLocationCoordinates());
    }

    @Test
    void mapWarehouseNextHopsEntityToDTO() {
        WarehouseNextHopsEntity warehouseNextHopsEntity = new WarehouseNextHopsEntity(1,27, new HopEntity(), null);

        WarehouseNextHops warehouseNextHopsDTO = WarehouseNextHopsMapper.INSTANCE.entityToDto(warehouseNextHopsEntity);

        assertEquals(warehouseNextHopsDTO.getTraveltimeMins(), warehouseNextHopsEntity.getTraveltimeMins());
        assertEquals(warehouseNextHopsDTO.getHop().getHopType(), warehouseNextHopsEntity.getHop().getHopType());
        assertEquals(warehouseNextHopsDTO.getHop().getCode(), warehouseNextHopsEntity.getHop().getCode());
        assertEquals(warehouseNextHopsDTO.getHop().getDescription(), warehouseNextHopsEntity.getHop().getDescription());
        assertEquals(warehouseNextHopsDTO.getHop().getProcessingDelayMins(), warehouseNextHopsEntity.getHop().getProcessingDelayMins());
        assertEquals(warehouseNextHopsDTO.getHop().getLocationName(), warehouseNextHopsEntity.getHop().getLocationName());
        assertEquals(warehouseNextHopsDTO.getHop().getLocationCoordinates(), warehouseNextHopsEntity.getHop().getLocationCoordinates());
    }
}
