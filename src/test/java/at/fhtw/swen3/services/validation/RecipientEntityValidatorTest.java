package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class RecipientEntityValidatorTest {
    private final RecipientEntityValidator recipientEntityValidator = new RecipientEntityValidator();

    private final ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);

    @Test
    void isValidWithCountryRequirement() {
        RecipientEntity recipientEntityWithAustria = new RecipientEntity(1,"TestEntity", "Vivaldigasse 5", "A-1234", "Wien", "Austria");
        RecipientEntity recipientEntityWithOesterreich = new RecipientEntity(2,"TestEntity", "Vivaldigasse 5", "A-1234", "Wien", "Österreich");
        assertTrue(recipientEntityValidator.isValid(recipientEntityWithAustria, constraintValidatorContext));
        assertTrue(recipientEntityValidator.isValid(recipientEntityWithOesterreich, constraintValidatorContext));
    }

    @Test
    void wrongStreetWithCountryRequirement() {
        RecipientEntity recipientEntityWithAustria = new RecipientEntity(3,"TestEntity", "5 Vivaldigasse 5", "A-1234", "Wien", "Austria");
        RecipientEntity recipientEntityWithOesterreich = new RecipientEntity(4,"TestEntity", "5 Vivaldigasse 5", "A-1234", "Wien", "Österreich");
        assertFalse(recipientEntityValidator.isValid(recipientEntityWithAustria, constraintValidatorContext));
        assertFalse(recipientEntityValidator.isValid(recipientEntityWithOesterreich, constraintValidatorContext));
    }

    @Test
    void wrongPostalCodeWithCountryRequirement() {
        RecipientEntity recipientEntityWithAustria = new RecipientEntity(5,"TestEntity", "Vivaldigasse 5", "B-1234", "Wien", "Austria");
        RecipientEntity recipientEntityWithOesterreich = new RecipientEntity(6,"TestEntity", "Vivaldigasse 5", "B-1234", "Wien", "Österreich");
        assertFalse(recipientEntityValidator.isValid(recipientEntityWithAustria, constraintValidatorContext));
        assertFalse(recipientEntityValidator.isValid(recipientEntityWithOesterreich, constraintValidatorContext));
    }

    @Test
    void wrongCityWithCountryRequirement() {
        RecipientEntity recipientEntityWithAustria = new RecipientEntity(7,"TestEntity", "Vivaldigasse 5", "A-1234", "wien", "Austria");
        RecipientEntity recipientEntityWithOesterreich = new RecipientEntity(8,"TestEntity", "Vivaldigasse 5", "A-1234", "wien", "Österreich");
        assertFalse(recipientEntityValidator.isValid(recipientEntityWithAustria, constraintValidatorContext));
        assertFalse(recipientEntityValidator.isValid(recipientEntityWithOesterreich, constraintValidatorContext));
    }

    @Test
    void isValidWithoutCountryRequirement() {
        RecipientEntity recipientEntity = new RecipientEntity(9,"TestEntity", "5 a-a", "B-1234", "121 Wien", "Spain");
        assertTrue(recipientEntityValidator.isValid(recipientEntity, constraintValidatorContext));
    }

}