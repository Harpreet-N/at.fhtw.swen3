package at.fhtw.swen3.persistence.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/application.properties")
public class TransferwarehouseRepositoryTest {

    @Autowired
    TransferwarehouseRepository transferwarehouseRepository;
}
