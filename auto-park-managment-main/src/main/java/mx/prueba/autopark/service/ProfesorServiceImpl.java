package mx.prueba.autopark.service;

import lombok.extern.slf4j.Slf4j;
import mx.prueba.autopark.domain.Profesor;
import mx.prueba.autopark.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    private ProfesorRepository repository;

    @Override
    public List<Profesor> getProfesores() {
        log.info("Fetching all Profesor");
        return repository.findAll();
    }
}
