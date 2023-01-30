package at.fhtw.swen3.persistence.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class HopEntity implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;

    @Column
    private String hopType;

    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    @NotNull
    @Column
    private String code;

    @Pattern(regexp = "[A-ZÄÜÖa-zöäüß0-9\\s\\-]+")
    @Column
    private String description;

    @Column
    private Integer processingDelayMins;

    @Column
    private String locationName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "GEO_COORDINATE_ID", referencedColumnName = "ID")
    private GeoCoordinateEntity locationCoordinates;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "WAREHOUSE_NEXT_HOPS_ID", referencedColumnName = "ID")
    private WarehouseNextHopsEntity warehouseNextHops;
}
