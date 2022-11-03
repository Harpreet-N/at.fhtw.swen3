package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.WarehouseNextHops;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class WarehouseEntity {
    private Integer level;

    private List<WarehouseNextHops> nextHops = new ArrayList<>();
}
