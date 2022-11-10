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
    private Float weight;

    @Column
    @ManyToOne
    private RecipientEntity recipient;

    @Column
    @ManyToOne
    private RecipientEntity sender;

    @Column
    private String trackingId;

    @Column
    private TrackingInformation.StateEnum state;

    @Column
    @OneToMany
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @Column
    @OneToMany
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

}
