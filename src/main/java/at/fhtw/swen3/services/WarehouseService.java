package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.exception.BLWarehouseException;
import org.springframework.stereotype.Service;

@Service
public interface WarehouseService {
    Warehouse exportWarehouses() throws BLWarehouseException;

    HopEntity getWarehouse(String code) throws BLWarehouseException;

    void importWarehouses(Warehouse warehouse) throws BLWarehouseException;
}
