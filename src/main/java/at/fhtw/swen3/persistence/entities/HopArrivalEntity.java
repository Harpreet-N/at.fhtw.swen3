package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HopArrivalEntity {

    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    @NotNull
    private String code;

    @Pattern(regexp = "[A-ZÄÜÖa-zöäüß0-9\\s\\-]+")
    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull
    private OffsetDateTime dateTime;

    @NotNull
    private List<ParcelEntity> parcelEntities = new ArrayList<>();

}
