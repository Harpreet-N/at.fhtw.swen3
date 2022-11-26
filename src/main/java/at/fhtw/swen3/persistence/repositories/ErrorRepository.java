package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ErrorRepository extends JpaRepository<ErrorEntity, Integer>  {
    @Override
    List<ErrorEntity> findAll();

    @Override
    List<ErrorEntity> findAllById(Iterable<Integer> integers);

    @Override
    void flush();

    @Override
    <S extends ErrorEntity> S saveAndFlush(S entity);


}
