package at.fhtw.swen3.repository;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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
