package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
