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
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgrupo;
    private String numeroGrupo;
    private String tipoGrupo;

    @ManyToMany
    @JoinTable(
            name = "alumno_pertenece_grupo",
            joinColumns = @JoinColumn(name = "id_grupo"),
            inverseJoinColumns = @JoinColumn(name = "id_alumno"))
    private Set<Alumno> alumnos = new HashSet<>();
}
