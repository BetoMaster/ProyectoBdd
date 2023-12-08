package mx.prueba.autopark.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.prueba.autopark.dto.response.ResponseAPI;
import mx.prueba.autopark.service.AlumnoService;
import mx.prueba.autopark.service.ProfesorService;
import mx.prueba.autopark.service.ProfesorLSCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AutoResource {

    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private ProfesorService profesorService;
    @Autowired
    private ProfesorLSCService profesorLSCService;

    @PostMapping(value = "/GET/alumnos", produces = "application/json")
    @ApiOperation(value = "Servicio que regresa una lista de todos los alumnos")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "Respuesta exitosa"),
            @ApiResponse(code = 401, message = "Sin autorización para usar el servicio"),
            @ApiResponse(code = 500, message = "Error inesperado")
    })
    public ResponseEntity<ResponseAPI> getAlumnosList(){
        ResponseAPI ResponseAPI = new ResponseAPI("AlumnoS_00","Llamado Correcto", alumnoService.getAlumnos());
        return new ResponseEntity<>(ResponseAPI, HttpStatus.CREATED);
    }

    @PostMapping(value = "/GET/profesores", produces = "application/json")
    @ApiOperation(value = "Servicio que regresa una lista de todos los profesores")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "Respuesta exitosa"),
            @ApiResponse(code = 401, message = "Sin autorización para usar el servicio"),
            @ApiResponse(code = 500, message = "Error inesperado")
    })
    public ResponseEntity<ResponseAPI> getProfesoresList(){
        ResponseAPI ResponseAPI = new ResponseAPI("ProfeS_00","Llamado Correcto", profesorService.getProfesores());
        return new ResponseEntity<>(ResponseAPI, HttpStatus.CREATED);
    }
    @PostMapping(value = "/GET/profesoresLSC", produces = "application/json")
    @ApiOperation(value = "Servicio que regresa una lista de todos los profesores de LSC")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "Respuesta exitosa"),
            @ApiResponse(code = 401, message = "Sin autorización para usar el servicio"),
            @ApiResponse(code = 500, message = "Error inesperado")
    })
    public ResponseEntity<ResponseAPI> getProfesoresLSCList(){
        ResponseAPI ResponseAPI = new ResponseAPI("ProfeSLSC_00","Llamado Correcto", profesorLSCService.getProfesorLSC());
        return new ResponseEntity<>(ResponseAPI, HttpStatus.CREATED);
    }

}
