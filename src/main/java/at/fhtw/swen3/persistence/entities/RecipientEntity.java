package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.validation.RecipientEntityConstraint;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RecipientEntityConstraint
@ToString
@EqualsAndHashCode
@Entity
public class RecipientEntity implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;

    @Pattern(regexp = "^[A-ZÄÜÖß][A-ZÄÜÖa-zöäüß\\s\\-]+")
    @Column
    private String name;

    @Pattern(regexp = "^[A-Za-zäöüß]+\\s[0-9a-z\\/]+")
    @Column
    private String street;

    @Pattern(regexp = "A-[0-9]{4}")
    @Column
    private String postalCode;

    @Pattern(regexp = "^[A-ZÄÜÖß][A-ZÄÜÖa-zöäüß\\s\\-]+")
    @Column
    private String city;

    @Pattern(regexp = "^.*(Österreich|Austria).*$")
    @Column
    private String country;

}
