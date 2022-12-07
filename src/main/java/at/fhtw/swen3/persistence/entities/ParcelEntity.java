package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ParcelEntity  implements BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;

    @Min(value = 0)
    @DecimalMin(value = "0")
    @Column
    private Float weight;

    @NotNull
    @OneToOne
    @JoinColumn(name="fk_recipient")
    private RecipientEntity recipient;

    @NotNull
    @OneToOne
    @JoinColumn(name="fk_sender")
    private RecipientEntity sender;

    @Pattern(regexp = "^[A-Z0-9]{9}$")
    @NotNull
    @Column
    private String trackingId;

    @Column
    private TrackingInformation.StateEnum state;

    @NotNull
    @OneToMany
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @NotNull
    @OneToMany
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

}
