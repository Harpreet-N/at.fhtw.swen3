package at.fhtw.swen3.persistence.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/application.properties")
class RecipientRepositoryTest {

//    @Autowired
//    RecipientRepository recipientRepository;

    @Test
    void test(){

    }

/*
    @Test
    public void findByIdTest() {
        RecipientEntity recipientEntity = RecipientEntity.builder().id(1).city("Wien").country("Austria").name("Time").postalCode("a-1234").street("Vivalligasse t").build();

        recipientRepository.save(recipientEntity);

        Optional<RecipientEntity> result = recipientRepository.findById(recipientEntity.getId());

        assertTrue(result.isPresent());

    }

     */
}