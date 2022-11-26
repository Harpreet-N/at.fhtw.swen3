package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TruckRepository extends JpaRepository<TruckEntity, Integer> {

    @Override
    List<TruckEntity> findAll();

    @Override
    List<TruckEntity> findAllById(Iterable<Integer> integers);

    @Override
    void flush();

    @Override
    <S extends TruckEntity> S saveAndFlush(S entity);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);
}
