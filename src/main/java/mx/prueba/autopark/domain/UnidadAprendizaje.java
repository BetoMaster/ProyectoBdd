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
public class UnidadAprendizaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idunidad_aprendizaje;
    private String nombre_UA;
    private String etapaFormacion;
    private Integer creditos;
    private Integer horasTotal;
    private String tipoCaracter;

    @ManyToMany(mappedBy = "unidadesAprendizaje")
    private Set<Grupo> grupos = new HashSet<>();
}
