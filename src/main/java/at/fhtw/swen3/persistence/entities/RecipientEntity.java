package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.validation.RecipientEntityConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RecipientEntityConstraint
public class RecipientEntity {

    @Pattern(regexp = "")
    private String name;

    @Pattern(regexp = "^[A-Za-zäöüß]+\\s[0-9a-z\\/]+")
    private String street;

    @Pattern(regexp = "A-[0-9]{4}")
    private String postalCode;

    @Pattern(regexp = "^[A-ZÄÜÖß].[A-ZÄÜÖa-zöäüß\\s\\-]+")
    private String city;

    @Pattern(regexp = "^.*(Österreich|Austria).*$")
    private String country;

}
