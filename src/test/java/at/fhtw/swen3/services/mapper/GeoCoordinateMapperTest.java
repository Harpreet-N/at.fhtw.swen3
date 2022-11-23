package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoCoordinateMapperTest {
    @Test
    void mapGeoCoordinateDTOToEntity() {
        GeoCoordinate geoCoordinateDTO = new GeoCoordinate();
        geoCoordinateDTO.lat(new Point(10,4));
        geoCoordinateDTO.lon(new Point(10,4));

        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateMapper.INSTANCE.dtoToEntity(geoCoordinateDTO);

        assertEquals(geoCoordinateDTO.getLat(), geoCoordinateEntity.getLat());
        assertEquals(geoCoordinateDTO.getLon(), geoCoordinateEntity.getLon());
    }

    @Test
    void mapGeoCoordinateEntityToDTO() {
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity(1, new Point(15,8), new Point(40,64));

        GeoCoordinate geoCoordinateDTO = GeoCoordinateMapper.INSTANCE.entityToDto(geoCoordinateEntity);

        assertEquals(geoCoordinateDTO.getLat(), geoCoordinateEntity.getLat());
        assertEquals(geoCoordinateDTO.getLon(), geoCoordinateEntity.getLon());
    }
}
