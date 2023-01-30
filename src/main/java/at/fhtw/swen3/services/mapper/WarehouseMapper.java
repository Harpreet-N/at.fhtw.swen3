package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {GeoCoordinateMapper.class, HopMapper.class}, builder = @Builder(disableBuilder = true))
public interface WarehouseMapper {
    WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);

    Warehouse entityToDto(WarehouseEntity warehouseEntity);

    WarehouseEntity dtoToEntity(Warehouse warehouse, @Context WarehouseMapperContext warehouseMapperContext);

    WarehouseEntity dtoToEntityNoContext(Warehouse warehouse);
}
