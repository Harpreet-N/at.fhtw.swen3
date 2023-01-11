package at.fhtw.swen3.persistence.entities;

import lombok.*;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class GeoCoordinateEntity  implements BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;


    @Column
    private Point location;
}
