package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class ParcelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private int id;

    @Column
    @Min(value = 0)
    private Float weight;

    @Column
    @NotNull
    @ManyToOne
    private RecipientEntity recipient;

    @Column
    @ManyToOne
    @NotNull
    private RecipientEntity sender;

    @Column
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;

    @Column
    @NotNull
    private TrackingInformation.StateEnum state;

    @Column
    @NotNull
    @OneToMany
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @Column
    @NotNull
    @OneToMany
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

}
