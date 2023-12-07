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

public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idprofesor;
    private Integer numEmpleado;
    private String nombreProfesor;
    private String apellidoProfesor;
    private String apellidoMaterno;
    private String rfcProfesor;

    @ManyToMany
    @JoinTable(
            name = "profesor_pertenece_programaeducativo",
            joinColumns = @JoinColumn(name = "id_profesor"),
            inverseJoinColumns = @JoinColumn(name = "id_programaeducativo"))
    private Set<ProgramaEducativo> programasEducativos = new HashSet<>();

}
