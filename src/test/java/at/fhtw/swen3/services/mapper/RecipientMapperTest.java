package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipientMapperTest {
    @Test
    void mapRecipientDTOToEntity() {
        Recipient recipientDTO = new Recipient();
        recipientDTO.city("Wien");
        recipientDTO.country("Austria");
        recipientDTO.name("Tim");
        recipientDTO.postalCode("A-1234");
        recipientDTO.street("Vivaldigasse 5");

        RecipientEntity recipientEntity = RecipientMapper.INSTANCE.dtoToEntity(recipientDTO);

        assertEquals(recipientDTO.getName(), recipientEntity.getName());
        assertEquals(recipientDTO.getCity(), recipientEntity.getCity());
        assertEquals(recipientDTO.getCountry(), recipientEntity.getCountry());
        assertEquals(recipientDTO.getPostalCode(), recipientEntity.getPostalCode());
        assertEquals(recipientDTO.getStreet(), recipientEntity.getStreet());
    }

    @Test
    void mapRecipientEntityToDTO() {
        RecipientEntity recipientEntity = new RecipientEntity(1,"Tim", "Vivaldigasse 5", "A-1234", "Wien", "Austria");

        Recipient recipientDTO = RecipientMapper.INSTANCE.entityToDto(recipientEntity);

        assertEquals(recipientDTO.getName(), recipientEntity.getName());
        assertEquals(recipientDTO.getCity(), recipientEntity.getCity());
        assertEquals(recipientDTO.getCountry(), recipientEntity.getCountry());
        assertEquals(recipientDTO.getPostalCode(), recipientEntity.getPostalCode());
        assertEquals(recipientDTO.getStreet(), recipientEntity.getStreet());
    }
}
