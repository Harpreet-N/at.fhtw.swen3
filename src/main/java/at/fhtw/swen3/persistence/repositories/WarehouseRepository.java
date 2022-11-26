package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Integer>  {

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
