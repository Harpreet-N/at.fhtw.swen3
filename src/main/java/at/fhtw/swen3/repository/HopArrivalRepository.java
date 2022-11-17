package at.fhtw.swen3.repository;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HopArrivalRepository extends JpaRepository<HopArrivalEntity, Integer>  {

    @Override
    List<HopArrivalEntity> findAll();

    @Override
    List<HopArrivalEntity> findAllById(Iterable<Integer> integers);

    @Override
    void flush();

    @Override
    <S extends HopArrivalEntity> S saveAndFlush(S entity);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);
}
