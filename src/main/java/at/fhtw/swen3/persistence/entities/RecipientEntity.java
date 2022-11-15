package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.validation.RecipientEntityConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RecipientEntityConstraint
public class RecipientEntity {
    private String name;

    private String street;

    private String postalCode;

    private String city;

    private String country;

}
