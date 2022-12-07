package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WarehouseEntity  implements BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;

    @Column
    private Integer level;

    @NotNull
    @OneToMany
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
