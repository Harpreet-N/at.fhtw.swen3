package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.services.ParcelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/application.properties")
public class ParcelServiceImplTest {
    private final ParcelService parcelService;

    @Autowired
    public ParcelServiceImplTest(ParcelServiceImpl parcelService) {
        this.parcelService = parcelService;
    }

    @Test
    void emptyTest(){

    }
}
