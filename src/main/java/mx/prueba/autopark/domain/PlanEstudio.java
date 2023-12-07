package mx.prueba.autopark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanEstudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlanEstudio;
    private String vigencia;
    private Integer creditosObligatorios;
    private Integer creditosOptativos;
    private Integer totalCreditos;

    @JoinColumn(name = "idProgramaEducativo", referencedColumnName = "idprogramaeducativo")
    @ManyToOne(optional = false)
    private ProgramaEducativo idProgramaEducativo;
}
