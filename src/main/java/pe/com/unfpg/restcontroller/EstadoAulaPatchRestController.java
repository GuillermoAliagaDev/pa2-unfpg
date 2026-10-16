package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoAulaEntity;
import pe.com.unfpg.service.EstadoAulaService;

@RestController
@RequestMapping("/api/estadoaula")
public class EstadoAulaPatchRestController {
    private final EstadoAulaService service;

    public EstadoAulaPatchRestController(EstadoAulaService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codesta}", "/{codesta}/habilitar"})
    public ResponseEntity<EstadoAulaEntity> habilitar(@PathVariable("codesta") Integer codesta) {
        return ResponseEntity.ok(service.habilitar(codesta));
    }
}
