package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;

    @Column
    private Integer traveltimeMins;

    @NotNull
    @Valid
    @OneToOne(mappedBy = "warehouseNextHops", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private HopEntity hop;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "WAREHOUSE_ID")
    private WarehouseEntity warehouse;

    public void setHop(HopEntity hop) {
        this.hop = hop;
        hop.setWarehouseNextHops(this);
    }
}
