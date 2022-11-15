package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class HopEntity {
    private String hopType;

    private String code;

    @Pattern(regexp = "[A-ZÄÜÖa-zöäüß0-9\\s\\-]+")
    private String description;

    private Integer processingDelayMins;

    private String locationName;

    @NotNull
    private GeoCoordinateEntity locationCoordinates;
}
