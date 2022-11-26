package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoCoordinateMapperTest {
    @Test
    void mapGeoCoordinateDTOToEntity() {
        GeoCoordinate geoCoordinateDTO = new GeoCoordinate();
        geoCoordinateDTO.lat(5.0);
        geoCoordinateDTO.lon(10.3);

        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateMapper.INSTANCE.dtoToEntity(geoCoordinateDTO);

        assertEquals(geoCoordinateDTO.getLat(), geoCoordinateEntity.getLat());
        assertEquals(geoCoordinateDTO.getLon(), geoCoordinateEntity.getLon());
    }

    @Test
    void mapGeoCoordinateEntityToDTO() {
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity(1,5.0, 10.3);

        GeoCoordinate geoCoordinateDTO = GeoCoordinateMapper.INSTANCE.entityToDto(geoCoordinateEntity);

        assertEquals(geoCoordinateDTO.getLat(), geoCoordinateEntity.getLat());
        assertEquals(geoCoordinateDTO.getLon(), geoCoordinateEntity.getLon());
    }
}
