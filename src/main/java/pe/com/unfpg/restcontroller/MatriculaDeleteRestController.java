package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.MatriculaEntity;
import pe.com.unfpg.service.MatriculaService;

@RestController
@RequestMapping("/api/matricula")
public class MatriculaDeleteRestController {
    private final MatriculaService service;

    public MatriculaDeleteRestController(MatriculaService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{nummat}", "/{nummat}/deshabilitar"})
    public ResponseEntity<MatriculaEntity> deshabilitar(@PathVariable("nummat") Integer nummat) {
        return ResponseEntity.ok(service.deshabilitar(nummat));
    }
}
