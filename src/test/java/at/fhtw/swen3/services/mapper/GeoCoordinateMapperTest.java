package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.WKTReader;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoCoordinateMapperTest {
    @Test
    void mapGeoCoordinateDTOToEntity() {
        GeoCoordinate geoCoordinateDTO = new GeoCoordinate();
        geoCoordinateDTO.lat(5.0);
        geoCoordinateDTO.lon(10.3);

        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateMapper.INSTANCE.dtoToEntity(geoCoordinateDTO);

        assertEquals(geoCoordinateDTO.getLat(), geoCoordinateEntity.getLocation().getX());
        assertEquals(geoCoordinateDTO.getLon(), geoCoordinateEntity.getLocation().getY());
    }

    @Test
    void mapGeoCoordinateEntityToDTO() {
        Point point = getDummyPoint();
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity(1, point);

        GeoCoordinate geoCoordinateDTO = GeoCoordinateMapper.INSTANCE.entityToDto(geoCoordinateEntity);

        assertEquals(geoCoordinateDTO.getLat(), geoCoordinateEntity.getLocation().getX());
        assertEquals(geoCoordinateDTO.getLon(), geoCoordinateEntity.getLocation().getY());
    }

    Point getDummyPoint() {
        try {
            String wktPoint = String.format(Locale.US, "POINT(%f %f)", 1.0, 1.0);
            Point point = (Point) new WKTReader().read(wktPoint);
            return point;
        } catch (Exception e) {
            return null;
        }
    }
}
