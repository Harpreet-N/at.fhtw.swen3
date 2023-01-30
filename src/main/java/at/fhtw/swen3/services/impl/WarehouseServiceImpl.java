package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.GeoCoordinateRepository;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseNextHopsRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.exception.BLWarehouseException;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapperContext;
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
    public Warehouse exportWarehouses() throws BLWarehouseException {
        var warehouseEntity = warehouseRepository.findByLevel(0);

        log.info("exportWarehouses successful");
        return WarehouseMapper.INSTANCE.entityToDto(warehouseEntity.get());
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
    public void importWarehouses(Warehouse warehouse) throws BLWarehouseException {
        try {
            var warehouseEntity = WarehouseMapper.INSTANCE.dtoToEntity(warehouse, new WarehouseMapperContext());
            warehouseRepository.deleteAll();
            warehouseRepository.save(warehouseEntity);
            log.info("importWarehouses successful");
        } catch (Exception e) {
            log.error("importWarehouses failed! Reason: {}", e.getMessage());
            throw new BLWarehouseException("importWarehouses failed");
        }
    }
}
