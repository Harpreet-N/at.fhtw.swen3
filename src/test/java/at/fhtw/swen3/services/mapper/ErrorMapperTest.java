package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.services.dto.Error;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorMapperTest {
    @Test
    void mapErrorDTOToEntity() {
        Error errorDTO = new Error();
        errorDTO.errorMessage("This is an error");

        ErrorEntity errorEntity = ErrorMapper.INSTANCE.dtoToEntity(errorDTO);

        assertEquals(errorEntity.getErrorMessage(), errorDTO.getErrorMessage());
    }

    @Test
    void mapErrorEntityToDTO() {
        ErrorEntity errorEntity = new ErrorEntity(1,"This is an error");

        Error errorDTO = ErrorMapper.INSTANCE.entityToDto(errorEntity);

        assertEquals(errorEntity.getErrorMessage(), errorDTO.getErrorMessage());
    }
}
