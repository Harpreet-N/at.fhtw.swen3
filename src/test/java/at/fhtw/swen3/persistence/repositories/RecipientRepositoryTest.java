package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/application.properties")
class RecipientRepositoryTest {
    private final RecipientRepository recipientRepository;
    private final BaseRepositoryTest baseRepositoryTest;

    @Autowired
    RecipientRepositoryTest(RecipientRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
        this.baseRepositoryTest = new BaseRepositoryTest();
    }

    @BeforeEach
    public void beforeEach() {
        recipientRepository.deleteAll();
    }

    @Test
    void testSave() {
        RecipientEntity recipientEntity = RecipientEntity.builder().name("Aa").street("Ngasse 1").postalCode("A-1234").city("Wien").country("Austria").build();
        baseRepositoryTest.testSave(recipientEntity, recipientRepository);
    }

    @Test
    void testFindById() {
        RecipientEntity recipientEntity = RecipientEntity.builder().name("Aa").street("Ngasse 1").postalCode("A-1234").city("Wien").country("Austria").build();
        baseRepositoryTest.testFindById(recipientEntity, recipientRepository);
    }

    @Test
    void testDelete() {
        RecipientEntity recipientEntity = RecipientEntity.builder().name("Aa").street("Ngasse 1").postalCode("A-1234").city("Wien").country("Austria").build();
        baseRepositoryTest.testDelete(recipientEntity, recipientRepository);
    }

    @Test
    void testFindAll() {
        RecipientEntity recipientEntity1 = RecipientEntity.builder().name("Aa").street("Ngasse 1").postalCode("A-1234").city("Wien").country("Austria").build();
        RecipientEntity recipientEntity2 = RecipientEntity.builder().name("Aa").street("Ngasse 2").postalCode("A-5678").city("Wien").country("Austria").build();
        baseRepositoryTest.testFindAll(recipientEntity1, recipientEntity2, recipientRepository);
    }

    @Test
    void testCount() {
        RecipientEntity recipientEntity1 = RecipientEntity.builder().name("Aa").street("Ngasse 1").postalCode("A-1234").city("Wien").country("Austria").build();
        RecipientEntity recipientEntity2 = RecipientEntity.builder().name("Aa").street("Ngasse 2").postalCode("A-5678").city("Wien").country("Austria").build();
        baseRepositoryTest.testCount(recipientEntity1, recipientEntity2, recipientRepository);
    }

}