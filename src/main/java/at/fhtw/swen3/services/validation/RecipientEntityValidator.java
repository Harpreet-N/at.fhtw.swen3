package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.persistence.entities.RecipientEntity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RecipientEntityValidator implements ConstraintValidator<RecipientEntityConstraint, RecipientEntity> {
    @Override
    public void initialize(RecipientEntityConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(RecipientEntity recipientEntity, ConstraintValidatorContext constraintValidatorContext) {
        if (recipientEntity.getCountry().equals("Österreich") || recipientEntity.getCountry().equals("Austria")) {
            if (!recipientEntity.getPostalCode().matches("A-[0-9]{4}")) {
                return false;
            }
            if (!recipientEntity.getStreet().matches("^[A-Za-zäöüß]+\\s[0-9a-z\\/]+")) {
                return false;
            }
            if (!recipientEntity.getCity().matches("^[A-ZÄÜÖß].[A-ZÄÜÖa-zöäüß\\s\\-]+")) {
                return false;
            }
        }
        return true;
    }
}
