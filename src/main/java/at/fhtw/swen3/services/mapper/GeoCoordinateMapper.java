package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.WKTReader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Locale;

@Mapper
public interface GeoCoordinateMapper {
    GeoCoordinateMapper INSTANCE = Mappers.getMapper(GeoCoordinateMapper.class);

    @Mapping(target = "lat", source = "location", qualifiedByName = "xToLat")
    @Mapping(target = "lon", source = "location", qualifiedByName = "yToLon")
    GeoCoordinate entityToDto(GeoCoordinateEntity geoCoordinateEntity);

    @Mapping(target = "location", source = "geoCoordinate", qualifiedByName = "coordsToPoint")
    GeoCoordinateEntity dtoToEntity(GeoCoordinate geoCoordinate);

    @Named("coordsToPoint")
    static Point coordsToPoint(GeoCoordinate geoCoordinate) {
        try {
            String wktPoint = String.format(Locale.US, "POINT(%f %f)", geoCoordinate.getLat(), geoCoordinate.getLon());
            Point point = (Point) new WKTReader().read(wktPoint);
            return point;
        } catch (Exception e) {
            return null;
        }
    }

    @Named("xToLat")
    static Double xToLat(Point location) {
        return location.getX();
    }

    @Named("yToLon")
    static Double yToLon(Point location) {
        return location.getY();
    }
}
