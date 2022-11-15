package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ParcelEntity {

    @Min(value = 0)
    private Float weight;

    @NotNull
    private RecipientEntity recipient;

    @NotNull
    private RecipientEntity sender;

    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;

    private TrackingInformation.StateEnum state;

    @NotNull
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @NotNull
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

}
