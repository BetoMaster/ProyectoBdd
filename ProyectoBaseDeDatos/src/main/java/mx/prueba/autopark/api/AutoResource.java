package mx.prueba.autopark.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.prueba.autopark.dto.response.ResponseAPI;
import mx.prueba.autopark.service.AlumnoService;
import mx.prueba.autopark.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AutoResource {
    
    @Autowired
    private AutoService autoService;
    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private ProfesorService profesorService;
    @Autowired
    private TipoAutoService tipoAutoService;

    @PostMapping(value = "/GET/autos", produces = "application/json")
    @ApiOperation(value = "Servicio que regresa una lista de todos los autos")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "Respuesta exitosa"),
            @ApiResponse(code = 401, message = "Sin autorización para usar el servicio"),
            @ApiResponse(code = 500, message = "Error inesperado")
    })
    public ResponseEntity<ResponseAPI> getAutosList(){
        ResponseAPI ResponseAPI = new ResponseAPI("AutoS_00","Llamado Correcto",autoService.getAutos());
        return new ResponseEntity<>(ResponseAPI, HttpStatus.CREATED);
    }

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

    @PostMapping(value = "/GET/autos-empresa", produces = "application/json")
    @ApiOperation(value = "Servicio que trae los autos de tipo empresa")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "Respuesta exitosa"),
            @ApiResponse(code = 403, message = "Sin autorización para usar el servicio"),
            @ApiResponse(code = 500, message = "Error inesperado")
    })
    public ResponseEntity<ResponseAPI> getAutosListEmpresa(){
        TipoAuto tipoAuto=tipoAutoService.findByTipo(TipoAutoEnum.EMPRESA.getTipo());
        ResponseAPI ResponseAPI = new ResponseAPI("AutoS_01","Listado Autos Empresa",autoService.findAllByTipo(tipoAuto));
        return new ResponseEntity<>(ResponseAPI, HttpStatus.CREATED);
    }

    @PostMapping(value = "/GET/autos-residente", produces = "application/json")
    @ApiOperation(value = "Servicio que trae los autos de tipo Residente")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "Respuesta exitosa"),
            @ApiResponse(code = 403, message = "Sin autorización para usar el servicio"),
            @ApiResponse(code = 500, message = "Error inesperado")
    })
    public ResponseEntity<ResponseAPI> getAutosListResidente(){
        TipoAuto tipoAuto=tipoAutoService.findByTipo(TipoAutoEnum.RESIDENTE.getTipo());
        ResponseAPI ResponseAPI = new ResponseAPI("AutoS_02","Listado Autos Residente",autoService.findAllByTipo(tipoAuto));
        return new ResponseEntity<>(ResponseAPI, HttpStatus.CREATED);
    }

    @PostMapping(value = "/SAVE/empresa-auto", produces = "application/json")
    @ApiOperation(value = "Servicio que realiza el guardado de Auto de empresa")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "Respuesta exitosa"),
            @ApiResponse(code = 403, message = "Sin autorización para usar el servicio"),
            @ApiResponse(code = 500, message = "Error inesperado")
    })
    public ResponseEntity<ResponseAPI> saveAutoEmpresa(@RequestBody RequestAuto auto){
        TipoAuto tipoAuto=tipoAutoService.findByTipo(TipoAutoEnum.EMPRESA.getTipo());
        return getResponseAPIResponseEntity(auto, tipoAuto);
    }

    @PostMapping(value = "/SAVE/residente-auto", produces = "application/json")
    @ApiOperation(value = "Servicio que realiza el guardado de Auto de residente")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "Respuesta exitosa"),
            @ApiResponse(code = 403, message = "Sin autorización para usar el servicio"),
            @ApiResponse(code = 500, message = "Error inesperado")
    })
    public ResponseEntity<ResponseAPI> saveAutoResidente(@RequestBody RequestAuto auto){
        TipoAuto tipoAuto=tipoAutoService.findByTipo(TipoAutoEnum.RESIDENTE.getTipo());
        return getResponseAPIResponseEntity(auto, tipoAuto);
    }

    @PostMapping(value = "/SAVE/auto", produces = "application/json")
    @ApiOperation(value = "Servicio que realiza el guardado de Auto")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "Respuesta exitosa"),
            @ApiResponse(code = 403, message = "Sin autorización para usar el servicio"),
            @ApiResponse(code = 500, message = "Error inesperado")
    })
    public ResponseEntity<ResponseAPI> saveAuto(@RequestBody RequestAuto auto){
        TipoAuto tipoAuto=tipoAutoService.findByTipo(auto.getTipo());
        return getResponseAPIResponseEntity(auto, tipoAuto);
    }

    private ResponseEntity<ResponseAPI> getResponseAPIResponseEntity(@RequestBody RequestAuto auto, TipoAuto tipoAuto) {
        ResponseAPI responseCorpoAPI;
        if(tipoAuto!=null){
            Auto autoToSave = new Auto();
            autoToSave.setMarca(auto.getMarca());
            autoToSave.setModelo(auto.getModelo());
            autoToSave.setYear(auto.getYear());
            autoToSave.setPlaca(auto.getPlaca());
            autoToSave.setFkTipoAuto(tipoAuto);
            responseCorpoAPI = new ResponseAPI("AutoS_03","Guardado Correcto",autoService.saveAuto(autoToSave));
        }else{
            responseCorpoAPI = new ResponseAPI("AutoS_04","Error al guardar auto",null);
        }


        return new ResponseEntity<>(responseCorpoAPI, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/DELETE/autos/{idAuto}")
    @ApiOperation(value = "Servicio que borra un Auto por ID")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "Respuesta exitosa"),
            @ApiResponse(code = 403, message = "Sin autorización para usar el servicio"),
            @ApiResponse(code = 500, message = "Error inesperado")
    })
    public ResponseEntity<?> deleteAuto(@PathVariable Long idAuto){
        if (!autoService.findById(idAuto).isPresent())
            return new ResponseEntity(new ResponseAPI("AutoS_05","Auto No encontrado",""), HttpStatus.NOT_FOUND);
        else
            autoService.removeAuto(idAuto);
        return new ResponseEntity(new ResponseAPI("AutoS_06","Borrado Correcto",""), HttpStatus.OK);
    }


}
