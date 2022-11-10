package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.GeoCoordinate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class HopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private int id;

    @Column
    private String hopType;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    private Integer processingDelayMins;

    @Column
    private String locationName;

    @Column
    @ManyToOne
    private GeoCoordinate locationCoordinates;
}
