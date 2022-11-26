package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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
