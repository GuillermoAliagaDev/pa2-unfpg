package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.AlumnoEntity;
import pe.com.unfpg.service.AlumnoService;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoDeleteRestController {
    private final AlumnoService service;

    public AlumnoDeleteRestController(AlumnoService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codalu}", "/{codalu}/deshabilitar"})
    public ResponseEntity<AlumnoEntity> deshabilitar(@PathVariable("codalu") Integer codalu) {
        return ResponseEntity.ok(service.deshabilitar(codalu));
    }
}
