package mx.prueba.autopark.repository;

import mx.prueba.autopark.domain.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
}
