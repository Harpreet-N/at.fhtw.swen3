package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.GeoCoordinateRepository;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseNextHopsRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.exception.BLWarehouseException;
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
    public WarehouseEntity exportWarehouses() throws BLWarehouseException {
        WarehouseEntity warehouseEntity;
        try {
            Optional<WarehouseEntity> optionalWarehouseEntity = warehouseRepository.findByLevel(0);
            if (optionalWarehouseEntity.isPresent()) {
                warehouseEntity = optionalWarehouseEntity.get();
            } else {
                throw new BLWarehouseException("Warehouse Hierarchy not found");
            }
        } catch (Exception e) {
            log.error("exportWarehouse failed! Reason: {}", e.getMessage());
            throw new BLWarehouseException("exportWarehouse failed");
        }
        log.info("exportWarehouses successful");
        return warehouseEntity;
    }

    @Override
    public HopEntity getWarehouse(String code) throws BLWarehouseException {
        HopEntity hopEntity;
        try {
            hopEntity = hopRepository.findByCode(code);
        } catch (Exception e) {
            log.error("getWarehouse failed! Reason: {}", e.getMessage());
            throw new BLWarehouseException("getWarehouse failed");
        }
        if (hopEntity != null) {
            log.info("getWarehouse successful");
            return hopEntity;
        }
        log.error("getWarehouse failed! Reason: Hop not found");
        throw new BLWarehouseException("getWarehouse failed");
    }

    @Override
    public void importWarehouses(WarehouseEntity warehouse) throws BLWarehouseException {
        try {
            warehouseRepository.deleteAll();
            warehouse.getNextHops().stream().map(warehouseNextHopsEntity -> warehouseNextHopsEntity.getHop().getLocationCoordinates()).forEach(geoCoordinateRepository::save);
            warehouse.getNextHops().stream().map(WarehouseNextHopsEntity::getHop).forEach(hopRepository::save);
            warehouseNextHopsRepository.saveAll(warehouse.getNextHops());
            warehouseRepository.save(warehouse);
            log.info("importWarehouses successful");
        } catch (Exception e) {
            log.error("importWarehouses failed! Reason: {}", e.getMessage());
            throw new BLWarehouseException("importWarehouses failed");
        }
    }
}
