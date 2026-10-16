package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.AlumnoEntity;
import pe.com.unfpg.service.AlumnoService;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoPatchRestController {
    private final AlumnoService service;

    public AlumnoPatchRestController(AlumnoService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codalu}", "/{codalu}/habilitar"})
    public ResponseEntity<AlumnoEntity> habilitar(@PathVariable("codalu") Integer codalu) {
        return ResponseEntity.ok(service.habilitar(codalu));
    }
}
