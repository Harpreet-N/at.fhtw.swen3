package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipientRepository extends JpaRepository<RecipientEntity, Integer> {

    @Override
    List<RecipientEntity> findAll();

    @Override
    List<RecipientEntity> findAllById(Iterable<Integer> integers);

    @Override
    <S extends RecipientEntity> List<S> saveAll(Iterable<S> entities);

    @Override
    void flush();

    @Override
    <S extends RecipientEntity> S saveAndFlush(S entity);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);
}
