package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class WarehouseNextHopsEntity implements BaseEntity {

    @Column(name="Warehouse_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;

    @Column
    private Integer traveltimeMins;

    @NotNull
    @OneToOne
    private HopEntity hop;

    @JoinColumn(name = "WAREHOUSE_ID")
    private WarehouseEntity warehouse;
}
