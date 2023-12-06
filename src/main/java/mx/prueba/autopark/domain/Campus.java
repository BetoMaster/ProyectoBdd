package mx.prueba.autopark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcampus;
    private String nombre;
}
