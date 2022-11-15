package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TransferwarehouseEntity {
    private String regionGeoJson;

    private String logisticsPartner;

    private String logisticsPartnerUrl;
}
