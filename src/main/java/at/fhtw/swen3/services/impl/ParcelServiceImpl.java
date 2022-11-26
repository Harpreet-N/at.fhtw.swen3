package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;

public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;

    @Autowired
    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }
}
