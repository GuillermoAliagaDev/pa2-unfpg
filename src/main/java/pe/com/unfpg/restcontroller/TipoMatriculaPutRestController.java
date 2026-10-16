package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoMatriculaEntity;
import pe.com.unfpg.service.TipoMatriculaService;

@RestController
@RequestMapping("/api/tipomatricula")
public class TipoMatriculaPutRestController {
    private final TipoMatriculaService service;

    public TipoMatriculaPutRestController(TipoMatriculaService service) {
        this.service = service;
    }

    @PutMapping("/{codtipm}")
    public ResponseEntity<TipoMatriculaEntity> actualizar(
            @PathVariable("codtipm") Integer codtipm,
            @RequestBody TipoMatriculaEntity datos) {
        return ResponseEntity.ok(service.actualizar(codtipm, datos));
    }
}
