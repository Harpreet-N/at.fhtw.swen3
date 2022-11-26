package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcelRepository extends JpaRepository<ParcelEntity, Integer>  {

    @Override
    List<ParcelEntity> findAll();

    @Override
    List<ParcelEntity> findAllById(Iterable<Integer> integers);

    @Override
    void flush();

    @Override
    <S extends ParcelEntity> S saveAndFlush(S entity);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);
}
