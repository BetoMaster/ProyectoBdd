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
public class Alumno {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idalumnos;
    private String nombre;
    private String apellidos;
    private String matricula;
    private String correo;

    @ManyToMany(mappedBy = "alumnos")
    private Set<Grupo> grupos = new HashSet<>();
}
