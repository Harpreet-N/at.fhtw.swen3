package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class WarehouseNextHopsEntity {
    private Integer traveltimeMins;

    @NotNull
    private HopEntity hop;
}
