package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HopEntity  implements BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;

    @Column
    private String hopType;

    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    @NotNull
    @Column
    private String code;

    @Pattern(regexp = "[A-ZÄÜÖa-zöäüß0-9\\s\\-]+")
    @Column
    private String description;

    @Column
    private Integer processingDelayMins;

    @Column
    private String locationName;

    @NotNull
    @OneToOne
    private GeoCoordinateEntity locationCoordinates;
}
