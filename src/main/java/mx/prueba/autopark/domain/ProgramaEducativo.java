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
public class ProgramaEducativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idprogramaeducativo;
    private Integer clavePE;
    private String nombrePE;

    @ManyToMany(mappedBy = "programasEducativos")
    private Set<Profesor> profesores = new HashSet<>();

    @OneToMany(mappedBy = "programaEducativo")
    private Set<Alumno> alumnos = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "pe_pertenece_campus",
            joinColumns = @JoinColumn(name = "id_pe"),
            inverseJoinColumns = @JoinColumn(name = "id_campus"))
    private Set<Campus> campus = new HashSet<>();
}
