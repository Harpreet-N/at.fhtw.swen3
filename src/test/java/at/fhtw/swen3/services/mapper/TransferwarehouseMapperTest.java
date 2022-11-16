package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferwarehouseMapperTest {
    @Test
    void mapTransferwarehouseDTOToEntity() {
        Transferwarehouse transferwarehouseDTO = new Transferwarehouse();
        transferwarehouseDTO.regionGeoJson("abc");
        transferwarehouseDTO.logisticsPartner("abc");
        transferwarehouseDTO.logisticsPartnerUrl("abc");

        TransferwarehouseEntity transferwarehouseEntity = TransferwarehouseMapper.INSTANCE.dtoToEntity(transferwarehouseDTO);

        assertEquals(transferwarehouseDTO.getRegionGeoJson(), transferwarehouseEntity.getRegionGeoJson());
        assertEquals(transferwarehouseDTO.getLogisticsPartner(), transferwarehouseEntity.getLogisticsPartner());
        assertEquals(transferwarehouseDTO.getLogisticsPartnerUrl(), transferwarehouseEntity.getLogisticsPartnerUrl());
    }

    @Test
    void mapTransferwarehouseEntityToDTO() {
        TransferwarehouseEntity transferwarehouseEntity = new TransferwarehouseEntity(1,"abc", "abc", "abc");

        Transferwarehouse transferwarehouseDTO = TransferwarehouseMapper.INSTANCE.entityToDto(transferwarehouseEntity);

        assertEquals(transferwarehouseDTO.getRegionGeoJson(), transferwarehouseEntity.getRegionGeoJson());
        assertEquals(transferwarehouseDTO.getLogisticsPartner(), transferwarehouseEntity.getLogisticsPartner());
        assertEquals(transferwarehouseDTO.getLogisticsPartnerUrl(), transferwarehouseEntity.getLogisticsPartnerUrl());
    }
}
