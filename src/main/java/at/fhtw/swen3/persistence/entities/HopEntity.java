package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class HopEntity {
    private String hopType;

    private String code;

    private String description;

    private Integer processingDelayMins;

    private String locationName;

    @NotNull
    private GeoCoordinateEntity locationCoordinates;
}
