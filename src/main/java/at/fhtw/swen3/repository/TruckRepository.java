package at.fhtw.swen3.repository;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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
