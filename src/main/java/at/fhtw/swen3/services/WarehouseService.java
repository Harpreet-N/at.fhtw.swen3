package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WarehouseService {
    List<WarehouseEntity> exportWarehouses();

    HopEntity getWarehouse(String code);

    void importWarehouses(WarehouseEntity warehouse);
}
