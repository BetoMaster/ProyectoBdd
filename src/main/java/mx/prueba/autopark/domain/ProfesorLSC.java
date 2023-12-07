package mx.prueba.autopark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorLSC {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idprofesor;
    private String nombre_profesor;
    private String rfc_profesor;
    private Integer num_empleado;
    private String nombrepe;
}
