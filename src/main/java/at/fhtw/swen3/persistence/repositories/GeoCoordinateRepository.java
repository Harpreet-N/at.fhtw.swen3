package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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
