package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferwarehouseEntity {
    private String regionGeoJson;

    private String logisticsPartner;

    private String logisticsPartnerUrl;
}
