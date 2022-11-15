package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientEntity {
    private int id;

    private String name;

    private String street;

    private String postalCode;

    private String city;

    private String country;

}
