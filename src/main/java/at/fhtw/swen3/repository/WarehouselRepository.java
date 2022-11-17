package at.fhtw.swen3.repository;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouselRepository extends JpaRepository<WarehouseEntity, Integer>  {

    @Override
    List<WarehouseEntity> findAll();

    @Override
    List<WarehouseEntity> findAllById(Iterable<Integer> integers);

    @Override
    void flush();

    @Override
    <S extends WarehouseEntity> S saveAndFlush(S entity);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);
}
