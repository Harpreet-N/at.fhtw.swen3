package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.Hop;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class WarehouseNextHopsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private int id;

    @Column
    private Integer traveltimeMins;

    @Column
    @ManyToOne
    private HopEntity hop;
}
