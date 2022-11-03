package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.Hop;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WarehouseNextHopsEntity {
    private Integer traveltimeMins;

    private Hop hop;
}
