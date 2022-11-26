package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeoCoordinateRepository extends JpaRepository<GeoCoordinateEntity, Integer> {
    @Override
    List<GeoCoordinateEntity> findAll();

    @Override
    List<GeoCoordinateEntity> findAllById(Iterable<Integer> integers);

    @Override
    void flush();

    @Override
    <S extends GeoCoordinateEntity> S saveAndFlush(S entity);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);
}
