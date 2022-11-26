package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;


public class RecipientServiceImpl implements RecipientService {

    private final RecipientRepository recipientRepository;

    @Autowired
    public RecipientServiceImpl(RecipientRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }
}
