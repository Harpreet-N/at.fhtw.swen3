package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransferwarehouseRepository extends JpaRepository<TransferwarehouseEntity, Integer> {
    @Override
    List<TransferwarehouseEntity> findAll();

    @Override
    List<TransferwarehouseEntity> findAllById(Iterable<Integer> integers);

    @Override
    void flush();

    @Override
    <S extends TransferwarehouseEntity> S saveAndFlush(S entity);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);
}
