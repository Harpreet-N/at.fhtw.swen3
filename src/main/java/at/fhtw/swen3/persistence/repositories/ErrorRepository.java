package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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