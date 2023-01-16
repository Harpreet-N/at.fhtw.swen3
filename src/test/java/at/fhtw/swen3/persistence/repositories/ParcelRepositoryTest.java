package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;

@SpringBootTest
@TestPropertySource("/application.properties")
public class ParcelRepositoryTest {
    private final RecipientRepository recipientRepository;
    private final ParcelRepository parcelRepository;
    private final BaseRepositoryTest baseRepositoryTest;

    @Autowired
    public ParcelRepositoryTest(RecipientRepository recipientRepository, ParcelRepository parcelRepository) {
        this.recipientRepository = recipientRepository;
        this.parcelRepository = parcelRepository;
        this.baseRepositoryTest = new BaseRepositoryTest();
    }

    @BeforeEach
    public void beforeEach() {
        parcelRepository.deleteAll();
    }

    @Test
    void testSave() {
        RecipientEntity recipientEntity = getDummyRecipientEntity();
        ParcelEntity parcelEntity = ParcelEntity.builder().weight(1.0f).recipient(recipientEntity).sender(recipientEntity).trackingId("ABC123DEF").state(TrackingInformation.StateEnum.PICKUP).visitedHops(new ArrayList<>()).futureHops(new ArrayList<>()).build();
        baseRepositoryTest.testSave(parcelEntity, parcelRepository);
    }

    @Test
    void testFindById() {
        RecipientEntity recipientEntity = getDummyRecipientEntity();
        ParcelEntity parcelEntity = ParcelEntity.builder().weight(1.0f).recipient(recipientEntity).sender(recipientEntity).trackingId("ABC123DEF").state(TrackingInformation.StateEnum.PICKUP).visitedHops(new ArrayList<>()).futureHops(new ArrayList<>()).build();
        baseRepositoryTest.testFindById(parcelEntity, parcelRepository);
    }

    @Test
    void testDelete() {
        RecipientEntity recipientEntity = getDummyRecipientEntity();
        ParcelEntity parcelEntity = ParcelEntity.builder().weight(1.0f).recipient(recipientEntity).sender(recipientEntity).trackingId("ABC123DEF").state(TrackingInformation.StateEnum.PICKUP).visitedHops(new ArrayList<>()).futureHops(new ArrayList<>()).build();
        baseRepositoryTest.testDelete(parcelEntity, parcelRepository);
    }

    @Test
    void testFindAll() {
        RecipientEntity recipientEntity = getDummyRecipientEntity();
        ParcelEntity parcelEntity1 = ParcelEntity.builder().weight(1.0f).recipient(recipientEntity).sender(recipientEntity).trackingId("ABC123DEF").state(TrackingInformation.StateEnum.PICKUP).visitedHops(new ArrayList<>()).futureHops(new ArrayList<>()).build();
        ParcelEntity parcelEntity2 = ParcelEntity.builder().weight(2.0f).recipient(recipientEntity).sender(recipientEntity).trackingId("ABC123DEG").state(TrackingInformation.StateEnum.PICKUP).visitedHops(new ArrayList<>()).futureHops(new ArrayList<>()).build();
        baseRepositoryTest.testFindAll(parcelEntity1,parcelEntity2, parcelRepository);
    }

    @Test
    void testCount() {
        RecipientEntity recipientEntity = getDummyRecipientEntity();
        ParcelEntity parcelEntity1 = ParcelEntity.builder().weight(1.0f).recipient(recipientEntity).sender(recipientEntity).trackingId("ABC123DEF").state(TrackingInformation.StateEnum.PICKUP).visitedHops(new ArrayList<>()).futureHops(new ArrayList<>()).build();
        ParcelEntity parcelEntity2 = ParcelEntity.builder().weight(2.0f).recipient(recipientEntity).sender(recipientEntity).trackingId("ABC123DEG").state(TrackingInformation.StateEnum.PICKUP).visitedHops(new ArrayList<>()).futureHops(new ArrayList<>()).build();
        baseRepositoryTest.testCount(parcelEntity1,parcelEntity2, parcelRepository);
    }

    RecipientEntity getDummyRecipientEntity(){
        RecipientEntity recipientEntity = RecipientEntity.builder().name("Aa").street("Ngasse 1").postalCode("A-1234").city("Wien").country("Austria").build();
        recipientRepository.save(recipientEntity);
        return recipientEntity;
    }


}
