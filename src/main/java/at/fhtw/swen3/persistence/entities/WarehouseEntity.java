package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WarehouseEntity {
    private Integer level;

    @NotNull
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
