package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoAulaEntity;
import pe.com.unfpg.service.EstadoAulaService;

@RestController
@RequestMapping("/api/estadoaula")
public class EstadoAulaPutRestController {
    private final EstadoAulaService service;

    public EstadoAulaPutRestController(EstadoAulaService service) {
        this.service = service;
    }

    @PutMapping("/{codesta}")
    public ResponseEntity<EstadoAulaEntity> actualizar(
            @PathVariable("codesta") Integer codesta,
            @RequestBody EstadoAulaEntity datos) {
        return ResponseEntity.ok(service.actualizar(codesta, datos));
    }
}