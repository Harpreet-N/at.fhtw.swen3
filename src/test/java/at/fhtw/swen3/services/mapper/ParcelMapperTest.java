package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO: fill list with dummy value and test conversion
public class ParcelMapperTest {
    @Test
    void mapParcelDTOToParcelEntity() {
        Parcel parcelDTO = new Parcel();
        parcelDTO.weight(78.4f);
        parcelDTO.recipient(new Recipient());
        parcelDTO.sender(new Recipient());

        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(new NewParcelInfo(), new TrackingInformation(), parcelDTO);

        assertEquals(parcelDTO.getWeight(), parcelEntity.getWeight());
        assertEquals(parcelDTO.getRecipient().getCity(), parcelEntity.getRecipient().getCity());
        assertEquals(parcelDTO.getRecipient().getName(), parcelEntity.getRecipient().getName());
        assertEquals(parcelDTO.getRecipient().getStreet(), parcelEntity.getRecipient().getStreet());
        assertEquals(parcelDTO.getRecipient().getCountry(), parcelEntity.getRecipient().getCountry());
        assertEquals(parcelDTO.getRecipient().getPostalCode(), parcelEntity.getRecipient().getPostalCode());
        assertEquals(parcelDTO.getSender().getCity(), parcelEntity.getSender().getCity());
        assertEquals(parcelDTO.getSender().getName(), parcelEntity.getSender().getName());
        assertEquals(parcelDTO.getSender().getStreet(), parcelEntity.getSender().getStreet());
        assertEquals(parcelDTO.getSender().getCountry(), parcelEntity.getSender().getCountry());
        assertEquals(parcelDTO.getSender().getPostalCode(), parcelEntity.getSender().getPostalCode());
    }

    @Test
    void mapNewParcelInfoDTOToParcelEntity() {
        NewParcelInfo newParcelInfoDTO = new NewParcelInfo();
        newParcelInfoDTO.trackingId("abc");

        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(newParcelInfoDTO, new TrackingInformation(), new Parcel());

        assertEquals(newParcelInfoDTO.getTrackingId(), parcelEntity.getTrackingId());
    }

    @Test
    void mapTrackingInformationDTOToParcelEntity() {
        TrackingInformation trackingInformationDTO = new TrackingInformation();
        trackingInformationDTO.state(TrackingInformation.StateEnum.PICKUP);
        trackingInformationDTO.visitedHops(new ArrayList<HopArrival>());
        trackingInformationDTO.futureHops(new ArrayList<HopArrival>());

        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(new NewParcelInfo(), trackingInformationDTO, new Parcel());

        assertEquals(trackingInformationDTO.getState(), parcelEntity.getState());
        assertEquals(trackingInformationDTO.getVisitedHops(), parcelEntity.getVisitedHops());
        assertEquals(trackingInformationDTO.getFutureHops(), parcelEntity.getFutureHops());
    }

    @Test
    void mapParcelEntityToParcelDTO() {
        ParcelEntity parcelEntity = new ParcelEntity(78.4f, new RecipientEntity(), new RecipientEntity(), "abc", TrackingInformation.StateEnum.PICKUP, new ArrayList<HopArrivalEntity>(), new ArrayList<HopArrivalEntity>());

        Parcel parcelDTO = ParcelMapper.INSTANCE.entityToParcelDto(parcelEntity);

        assertEquals(parcelDTO.getWeight(), parcelEntity.getWeight());
        assertEquals(parcelDTO.getRecipient().getCity(), parcelEntity.getRecipient().getCity());
        assertEquals(parcelDTO.getRecipient().getName(), parcelEntity.getRecipient().getName());
        assertEquals(parcelDTO.getRecipient().getStreet(), parcelEntity.getRecipient().getStreet());
        assertEquals(parcelDTO.getRecipient().getCountry(), parcelEntity.getRecipient().getCountry());
        assertEquals(parcelDTO.getRecipient().getPostalCode(), parcelEntity.getRecipient().getPostalCode());
        assertEquals(parcelDTO.getSender().getCity(), parcelEntity.getSender().getCity());
        assertEquals(parcelDTO.getSender().getName(), parcelEntity.getSender().getName());
        assertEquals(parcelDTO.getSender().getStreet(), parcelEntity.getSender().getStreet());
        assertEquals(parcelDTO.getSender().getCountry(), parcelEntity.getSender().getCountry());
        assertEquals(parcelDTO.getSender().getPostalCode(), parcelEntity.getSender().getPostalCode());
    }

    @Test
    void mapParcelEntityToNewParcelInfoDTO() {
        ParcelEntity parcelEntity = new ParcelEntity(78.4f, new RecipientEntity(), new RecipientEntity(), "abc", TrackingInformation.StateEnum.PICKUP, new ArrayList<HopArrivalEntity>(), new ArrayList<HopArrivalEntity>());

        NewParcelInfo newParcelInfoDTO = ParcelMapper.INSTANCE.entityToNewParcelInfoDto(parcelEntity);

        assertEquals(newParcelInfoDTO.getTrackingId(), parcelEntity.getTrackingId());
    }

    @Test
    void mapParcelEntityToTrackingInformationDTO() {
        ParcelEntity parcelEntity = new ParcelEntity(78.4f, new RecipientEntity(), new RecipientEntity(), "abc", TrackingInformation.StateEnum.PICKUP, new ArrayList<HopArrivalEntity>(), new ArrayList<HopArrivalEntity>());

        TrackingInformation trackingInformationDTO = ParcelMapper.INSTANCE.entityToTrackingInformationDto(parcelEntity);

        assertEquals(trackingInformationDTO.getState(), parcelEntity.getState());
        assertEquals(trackingInformationDTO.getVisitedHops(), parcelEntity.getVisitedHops());
        assertEquals(trackingInformationDTO.getFutureHops(), parcelEntity.getFutureHops());
    }
}
