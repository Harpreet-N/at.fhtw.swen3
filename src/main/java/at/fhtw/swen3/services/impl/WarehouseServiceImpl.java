package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.GeoCoordinateRepository;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseNextHopsRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseNextHopsRepository warehouseNextHopsRepository;
    private final HopRepository hopRepository;
    private final GeoCoordinateRepository geoCoordinateRepository;

    @Override
    public Optional<WarehouseEntity> exportWarehouses() {
        return warehouseRepository.findByLevel(0);
    }

    @Override
    public HopEntity getWarehouse(String code) {
        return hopRepository.findByCode(code);
    }

    @Override
    public void importWarehouses(WarehouseEntity warehouse) {
        warehouseRepository.deleteAll();
        warehouse.getNextHops().stream().map(warehouseNextHopsEntity -> warehouseNextHopsEntity.getHop().getLocationCoordinates()).forEach(geoCoordinateRepository::save);
        warehouse.getNextHops().stream().map(WarehouseNextHopsEntity::getHop).forEach(hopRepository::save);
        warehouseNextHopsRepository.saveAll(warehouse.getNextHops());
        warehouseRepository.save(warehouse);
    }
}
