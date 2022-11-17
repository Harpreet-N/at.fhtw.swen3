package at.fhtw.swen3.repository;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HopRepository extends JpaRepository<HopEntity, Integer>  {

    @Override
    List<HopEntity> findAll();

    @Override
    List<HopEntity> findAllById(Iterable<Integer> integers);

    @Override
    void flush();

    @Override
    <S extends HopEntity> S saveAndFlush(S entity);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);
}
