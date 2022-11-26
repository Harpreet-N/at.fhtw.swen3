package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.WarehouselRepository;
import at.fhtw.swen3.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;

public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouselRepository recipientRepository;

    @Autowired
    public WarehouseServiceImpl(WarehouselRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }
}
