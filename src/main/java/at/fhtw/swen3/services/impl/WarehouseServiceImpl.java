package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final HopRepository hopRepository;

    @Override
    public List<WarehouseEntity> exportWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    public HopEntity getWarehouse(String code) {
        return hopRepository.findByCode(code);
    }

    @Override
    public void importWarehouses(WarehouseEntity warehouse) {
        warehouseRepository.deleteAll();
        warehouseRepository.save(warehouse);
    }
}
