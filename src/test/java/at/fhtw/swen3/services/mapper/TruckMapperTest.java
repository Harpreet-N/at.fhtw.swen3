package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TruckMapperTest {
    @Test
    void mapTruckDTOToEntity() {
        Truck truckDTO = new Truck();
        truckDTO.regionGeoJson("abc");
        truckDTO.numberPlate("W-12345");

        TruckEntity truckEntity = TruckMapper.INSTANCE.dtoToEntity(truckDTO);

        assertEquals(truckDTO.getRegionGeoJson(), truckEntity.getRegionGeoJson());
        assertEquals(truckDTO.getNumberPlate(), truckEntity.getNumberPlate());
    }

    @Test
    void mapTruckEntityToDTO() {
        TruckEntity truckEntity = new TruckEntity(1,"abc", "W-12345");

        Truck truckDTO = TruckMapper.INSTANCE.entityToDto(truckEntity);

        assertEquals(truckDTO.getRegionGeoJson(), truckEntity.getRegionGeoJson());
        assertEquals(truckDTO.getNumberPlate(), truckEntity.getNumberPlate());
    }
}
