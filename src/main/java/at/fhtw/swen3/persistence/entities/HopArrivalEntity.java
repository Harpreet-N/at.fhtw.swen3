package at.fhtw.swen3.persistence.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class HopArrivalEntity implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;

    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    @NotNull
    @Column
    private String code;

    @Pattern(regexp = "[A-ZÄÜÖa-zöäüß0-9\\s\\-]+")
    @Column
    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull
    @Column
    private OffsetDateTime dateTime;

    @NotNull
    @OneToMany
    @JoinColumn(name = "fk_parcelEntries")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ParcelEntity> parcel = new ArrayList<>();

}
