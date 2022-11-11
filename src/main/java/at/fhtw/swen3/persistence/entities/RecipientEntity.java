package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
public class RecipientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String street;

    @Column
    private String postalCode;

    @Column
    private String city;

    @Column
    private String country;

}
