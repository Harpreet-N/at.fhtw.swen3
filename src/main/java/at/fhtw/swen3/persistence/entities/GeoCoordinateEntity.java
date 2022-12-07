package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.awt.*;

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


    @Column(columnDefinition="Point")
    private Point lat;

    @Column(columnDefinition="Point")
    private Point  lon;
}
