package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HopMapperTest {
    @Test
    void mapHopDTOToEntity() {
        Hop hopDTO = new Hop();
        hopDTO.hopType("abc");
        hopDTO.code("abc");
        hopDTO.description("abc");
        hopDTO.processingDelayMins(23);
        hopDTO.locationName("abc");
        hopDTO.locationCoordinates(new GeoCoordinate());

        HopEntity hopEntity = HopMapper.INSTANCE.dtoToEntity(hopDTO);

        assertEquals(hopDTO.getHopType(), hopEntity.getHopType());
        assertEquals(hopDTO.getCode(), hopEntity.getCode());
        assertEquals(hopDTO.getDescription(), hopEntity.getDescription());
        assertEquals(hopDTO.getProcessingDelayMins(), hopEntity.getProcessingDelayMins());
        assertEquals(hopDTO.getLocationName(), hopEntity.getLocationName());
        assertEquals(hopDTO.getLocationCoordinates().getLat(), hopEntity.getLocationCoordinates().getLat());
        assertEquals(hopDTO.getLocationCoordinates().getLon(), hopEntity.getLocationCoordinates().getLon());
    }

    @Test
    void mapHopEntityToDTO() {
        HopEntity hopEntity = new HopEntity(1,"abc", "abc", "abc", 23, "abc", new GeoCoordinateEntity());

        Hop hopDTO = HopMapper.INSTANCE.entityToDto(hopEntity);

        assertEquals(hopDTO.getHopType(), hopEntity.getHopType());
        assertEquals(hopDTO.getCode(), hopEntity.getCode());
        assertEquals(hopDTO.getDescription(), hopEntity.getDescription());
        assertEquals(hopDTO.getProcessingDelayMins(), hopEntity.getProcessingDelayMins());
        assertEquals(hopDTO.getLocationName(), hopEntity.getLocationName());
        assertEquals(hopDTO.getLocationCoordinates().getLat(), hopEntity.getLocationCoordinates().getLat());
        assertEquals(hopDTO.getLocationCoordinates().getLon(), hopEntity.getLocationCoordinates().getLon());
    }
}
