package at.fhtw.swen3.persistence.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
public class HopArrivalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private int id;

    @Column
    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    private String code;
    @Column
    private String description;


    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dateTime;
}
