package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.AlumnoEntity;
import pe.com.unfpg.service.AlumnoService;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoPutRestController {
    private final AlumnoService service;
    public AlumnoPutRestController(AlumnoService service) { this.service = service; }

    @PutMapping("/{codalu}")
    public ResponseEntity<AlumnoEntity> actualizar(@PathVariable("codalu") Integer codalu, @RequestBody AlumnoEntity datos) {
        return ResponseEntity.ok(service.actualizar(codalu, datos));
    }
}
