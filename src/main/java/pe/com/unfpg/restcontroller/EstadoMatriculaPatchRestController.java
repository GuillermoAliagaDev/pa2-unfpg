package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoMatriculaEntity;
import pe.com.unfpg.service.EstadoMatriculaService;

@RestController
@RequestMapping("/api/estadomatricula")
public class EstadoMatriculaPatchRestController {
    private final EstadoMatriculaService service;

    public EstadoMatriculaPatchRestController(EstadoMatriculaService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codestm}", "/{codestm}/habilitar"})
    public ResponseEntity<EstadoMatriculaEntity> habilitar(@PathVariable("codestm") Integer codestm) {
        return ResponseEntity.ok(service.habilitar(codestm));
    }
}
