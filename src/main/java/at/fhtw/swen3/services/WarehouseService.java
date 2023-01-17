package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface WarehouseService {
    Optional<WarehouseEntity> exportWarehouses();

    HopEntity getWarehouse(String code);

    void importWarehouses(WarehouseEntity warehouse);
}
