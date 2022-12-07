package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ErrorEntity implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;

    @Column
    private String errorMessage;
}
