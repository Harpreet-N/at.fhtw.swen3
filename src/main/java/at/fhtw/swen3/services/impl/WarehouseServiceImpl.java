package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
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

    private final WarehouseRepository recipientRepository;

    @Override
    public Optional<WarehouseEntity> exportWarehouses() {
        return Optional.empty();
    }

    @Override
    public Optional<HopEntity> getWarehouse(String code) {
        return Optional.empty();
    }

    @Override
    public void importWarehouses(WarehouseEntity warehouse) {

    }
}
