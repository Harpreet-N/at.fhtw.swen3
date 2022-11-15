package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.validation.RecipientEntityConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RecipientEntityConstraint
public class RecipientEntity {
    private String name;

    private String street;

    private String postalCode;

    private String city;

    private String country;

}
