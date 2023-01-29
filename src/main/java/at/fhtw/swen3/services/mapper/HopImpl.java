package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import at.fhtw.swen3.services.dto.Truck;
import at.fhtw.swen3.services.dto.Warehouse;

public class HopImpl implements HopMapper {

    private final HopMapper delegate;

    protected HopImpl(HopMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public HopEntity dtoToEntity(Hop hop) {
        if (hop instanceof Transferwarehouse) {
            return TransferwarehouseMapper.INSTANCE.dtoToEntity((Transferwarehouse) hop);
        } else if (hop instanceof Warehouse) {
            return WarehouseMapper.INSTANCE.dtoToEntity((Warehouse) hop, new WarehouseMapperContext());
        } else if (hop instanceof Truck) {
            return TruckMapper.INSTANCE.dtoToEntity((Truck) hop);
        }
        return delegate.dtoToEntity(hop);
    }

    @Override
    public Hop entityToDto(HopEntity hop) {
        if (hop instanceof TransferwarehouseEntity) {
            return TransferwarehouseMapper.INSTANCE.entityToDto((TransferwarehouseEntity) hop);
        }  else if (hop instanceof WarehouseEntity) {
            return WarehouseMapper.INSTANCE.entityToDto((WarehouseEntity) hop);
        } else if (hop instanceof TruckEntity){
            return TruckMapper.INSTANCE.entityToDto((TruckEntity) hop);
        }
        return delegate.entityToDto(hop);
    }
}
