package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class BaseRepositoryTest {
    public void testSave(BaseEntity entity, JpaRepository repository) {
        BaseEntity savedEntity = (BaseEntity) repository.save(entity);
        assertEquals(entity, savedEntity);
    }

    public void testFindById(BaseEntity entity, JpaRepository repository) {
        entity = (BaseEntity) repository.save(entity);
        Optional<BaseEntity> foundEntity = repository.findById(entity.getId());
        assertTrue(foundEntity.isPresent());
        assertEquals(entity, foundEntity.get());
    }

    public void testDelete(BaseEntity entity, JpaRepository repository) {
        entity = (BaseEntity) repository.save(entity);
        repository.delete(entity);
        Optional<BaseEntity> foundEntity = repository.findById(entity.getId());
        assertFalse(foundEntity.isPresent());
    }

    public void testFindAll(BaseEntity entity1, BaseEntity entity2, JpaRepository repository) {
        entity1 = (BaseEntity) repository.save(entity1);

        entity2 = (BaseEntity) repository.save(entity2);

        List<BaseEntity> entities = repository.findAll();
        assertEquals(2, entities.size());
        assertTrue(entities.contains(entity1));
        assertTrue(entities.contains(entity2));
    }

    public void testCount(BaseEntity entity1, BaseEntity entity2, JpaRepository repository) {
        entity1 = (BaseEntity) repository.save(entity1);
        entity2 = (BaseEntity) repository.save(entity2);
        long count = repository.count();
        assertEquals(2, count);
    }
}
