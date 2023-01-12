package at.fhtw.swen3.gps.service.models;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Address {
    private String street;
    private String postalCode;
    private String city;
    private String country;
}
