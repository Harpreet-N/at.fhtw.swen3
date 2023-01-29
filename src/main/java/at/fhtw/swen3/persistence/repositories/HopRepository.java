package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopEntity;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HopRepository extends JpaRepository<HopEntity, Integer>  {

    HopEntity findByCode(String code);


}
