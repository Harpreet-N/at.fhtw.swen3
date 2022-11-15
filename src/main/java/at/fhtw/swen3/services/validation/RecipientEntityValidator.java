package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RecipientEntityValidator implements Validator {

    @Override
    public boolean supports(Class<?> c) {
        return RecipientEntity.class.equals(c);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RecipientEntity recipientEntity = (RecipientEntity) target;

        if (recipientEntity.getCity().equals("Österreich") || recipientEntity.getCity().equals("Austria")) {
            if (!recipientEntity.getPostalCode().matches("A-[0-9]{4}")) {
                errors.rejectValue("postalCode", "Postal Code is not in the correct pattern");
            }
            if (!recipientEntity.getStreet().matches("^[A-Z].[a-zäöüß]+\\s[0-9a-z\\/]+")) {
                errors.rejectValue("street", "Street is not in the correct pattern");
            }
            if (!recipientEntity.getCity().matches("^[A-ZÄÜÖß].[A-ZÄÜÖa-zöäüß\\s\\-]+")) {
                errors.rejectValue("city", "City is not in the correct pattern");
            }
        }
    }
}
