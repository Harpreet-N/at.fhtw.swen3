package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HopArrivalMapperTest {
    @Test
    void mapHopArrivalDTOToEntity() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        HopArrival hopArrivalDTO = new HopArrival();
        hopArrivalDTO.code("AAAA1");
        hopArrivalDTO.dateTime(offsetDateTime);
        hopArrivalDTO.description("Warehouse-12");

        HopArrivalEntity hopArrivalEntity = HopArrivalMapper.INSTANCE.dtoToEntity(hopArrivalDTO);

        assertEquals(hopArrivalEntity.getCode(), hopArrivalDTO.getCode());
        assertEquals(hopArrivalEntity.getDescription(), hopArrivalDTO.getDescription());
        assertEquals(hopArrivalEntity.getDateTime(), hopArrivalDTO.getDateTime());
    }

    @Test
    void mapHopArrivalEntityToDTO() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity(1,"A-1120", "Warehouse-12", offsetDateTime, null);

        HopArrival hopArrivalDTO = HopArrivalMapper.INSTANCE.entityToDto(hopArrivalEntity);

        assertEquals(hopArrivalEntity.getCode(), hopArrivalDTO.getCode());
        assertEquals(hopArrivalEntity.getDescription(), hopArrivalDTO.getDescription());
        assertEquals(hopArrivalEntity.getDateTime(), hopArrivalDTO.getDateTime());
    }
}
