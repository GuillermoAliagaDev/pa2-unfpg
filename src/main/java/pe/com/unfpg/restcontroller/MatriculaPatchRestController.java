package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.MatriculaEntity;
import pe.com.unfpg.service.MatriculaService;

@RestController
@RequestMapping("/api/matricula")
public class MatriculaPatchRestController {
    private final MatriculaService service;

    public MatriculaPatchRestController(MatriculaService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{nummat}", "/{nummat}/habilitar"})
    public ResponseEntity<MatriculaEntity> habilitar(@PathVariable("nummat") Integer nummat) {
        return ResponseEntity.ok(service.habilitar(nummat));
    }
}
