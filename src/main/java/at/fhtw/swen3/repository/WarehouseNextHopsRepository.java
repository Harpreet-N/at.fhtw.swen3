package at.fhtw.swen3.repository;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseNextHopsRepository extends JpaRepository<WarehouseNextHopsEntity, Integer> {

    @Override
    List<WarehouseNextHopsEntity> findAll();

    @Override
    List<WarehouseNextHopsEntity> findAllById(Iterable<Integer> integers);

    @Override
    void flush();

    @Override
    <S extends WarehouseNextHopsEntity> S saveAndFlush(S entity);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);
}
