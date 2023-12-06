package mx.prueba.autopark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idprofesor;
    private Integer numEmpleado;
    private String nombreProfesor;
    private String apellidoProfesor;
    private String apellidoMaterno;
    private String rfcProfesor;
}
