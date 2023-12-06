package mx.prueba.autopark.service;


import lombok.extern.slf4j.Slf4j;
import mx.prueba.autopark.domain.Alumno;
import mx.prueba.autopark.domain.Auto;
import mx.prueba.autopark.domain.TipoAuto;
import mx.prueba.autopark.repository.AlumnoRepository;
import mx.prueba.autopark.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class AlumnoServiceImpl implements AlumnoService{

    @Autowired
    private AlumnoRepository repository;

    @Override
    public List<Alumno> getAlumnos() {
        log.info("Fetching all Autos");
        return repository.findAll();
    }

}
