package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.WarehouseNextHops;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private int id;

    @Column
    private Integer level;

    @Column
    @NotNull
    @OneToMany
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
