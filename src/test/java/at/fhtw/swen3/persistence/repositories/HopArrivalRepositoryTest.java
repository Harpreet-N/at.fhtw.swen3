package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

@SpringBootTest
@TestPropertySource("/application.properties")
public class HopArrivalRepositoryTest {
    private final HopArrivalRepository hopArrivalRepository;
    private final BaseRepositoryTest baseRepositoryTest;
    @Autowired
    public HopArrivalRepositoryTest(HopArrivalRepository hopArrivalRepository) {
        this.hopArrivalRepository = hopArrivalRepository;
        this.baseRepositoryTest = new BaseRepositoryTest();
    }

    @BeforeEach
    public void beforeEach(){
        hopArrivalRepository.deleteAll();
    }

    @Test
    public void testSave(){
        OffsetDateTime offsetDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        HopArrivalEntity hopArrivalEntity = HopArrivalEntity.builder().code("AAAA1111").description("abc").dateTime(offsetDateTime).parcel(new ArrayList<>()).build();
        baseRepositoryTest.testSave(hopArrivalEntity, hopArrivalRepository);
    }

    @Test
    public void testFindById() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        HopArrivalEntity hopArrivalEntity = HopArrivalEntity.builder().code("AAAA1111").description("abc").dateTime(offsetDateTime).parcel(new ArrayList<>()).build();
        baseRepositoryTest.testFindById(hopArrivalEntity, hopArrivalRepository);
    }
    @Test
    public void testDelete() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        HopArrivalEntity hopArrivalEntity = HopArrivalEntity.builder().code("AAAA1111").description("abc").dateTime(offsetDateTime).parcel(new ArrayList<>()).build();
        baseRepositoryTest.testDelete(hopArrivalEntity, hopArrivalRepository);
    }
    @Test
    public void testFindAll() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        HopArrivalEntity hopArrivalEntity1 = HopArrivalEntity.builder().code("AAAA1111").description("abc").dateTime(offsetDateTime).parcel(new ArrayList<>()).build();
        HopArrivalEntity hopArrivalEntity2 = HopArrivalEntity.builder().code("AAAA2222").description("abc").dateTime(offsetDateTime).parcel(new ArrayList<>()).build();
        baseRepositoryTest.testFindAll(hopArrivalEntity1, hopArrivalEntity2, hopArrivalRepository);
    }
    @Test
    public void testCount() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        HopArrivalEntity hopArrivalEntity1 = HopArrivalEntity.builder().code("AAAA1111").description("abc").dateTime(offsetDateTime).parcel(new ArrayList<>()).build();
        HopArrivalEntity hopArrivalEntity2 = HopArrivalEntity.builder().code("AAAA2222").description("abc").dateTime(offsetDateTime).parcel(new ArrayList<>()).build();
        baseRepositoryTest.testCount(hopArrivalEntity1, hopArrivalEntity2, hopArrivalRepository);
    }
}
