package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HopEntity {
    private String hopType;

    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    @NotNull
    private String code;

    @Pattern(regexp = "[A-ZÄÜÖa-zöäüß0-9\\s\\-]+")
    private String description;

    private Integer processingDelayMins;

    private String locationName;

    @NotNull
    private GeoCoordinateEntity locationCoordinates;
}
