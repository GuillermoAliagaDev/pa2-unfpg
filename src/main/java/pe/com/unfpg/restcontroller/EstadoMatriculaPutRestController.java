package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoMatriculaEntity;
import pe.com.unfpg.service.EstadoMatriculaService;

@RestController
@RequestMapping("/api/estadomatricula")
public class EstadoMatriculaPutRestController {
    private final EstadoMatriculaService service;

    public EstadoMatriculaPutRestController(EstadoMatriculaService service) {
        this.service = service;
    }

    @PutMapping("/{codestm}")
    public ResponseEntity<EstadoMatriculaEntity> actualizar(
            @PathVariable("codestm") Integer codestm,
            @RequestBody EstadoMatriculaEntity datos) {
        return ResponseEntity.ok(service.actualizar(codestm, datos));
    }
}
