package mx.prueba.autopark.service;


import lombok.extern.slf4j.Slf4j;
import mx.prueba.autopark.domain.ProfesorLSC;
import mx.prueba.autopark.repository.ProfesorLSCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class ProfesorLSCServiceImpl implements ProfesorLSCService{

    @Autowired
    private ProfesorLSCRepository repository;

    @Override
    public List<ProfesorLSC> getProfesorLSC() {
        log.info("Fetching all ProfesorLSC");
        return repository.findAll();
    }

}
