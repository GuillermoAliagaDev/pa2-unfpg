package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoMatriculaEntity;
import pe.com.unfpg.service.EstadoMatriculaService;

@RestController
@RequestMapping("/api/estadomatricula")
public class EstadoMatriculaDeleteRestController {
    private final EstadoMatriculaService service;

    public EstadoMatriculaDeleteRestController(EstadoMatriculaService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codestm}", "/{codestm}/deshabilitar"})
    public ResponseEntity<EstadoMatriculaEntity> deshabilitar(@PathVariable("codestm") Integer codestm) {
        return ResponseEntity.ok(service.deshabilitar(codestm));
    }
}
