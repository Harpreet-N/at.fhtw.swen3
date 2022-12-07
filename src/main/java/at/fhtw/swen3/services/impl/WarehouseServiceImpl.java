package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository recipientRepository;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }
}
