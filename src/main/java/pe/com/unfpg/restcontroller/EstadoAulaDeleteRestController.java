package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoAulaEntity;
import pe.com.unfpg.service.EstadoAulaService;

@RestController
@RequestMapping("/api/estadoaula")
public class EstadoAulaDeleteRestController {
    private final EstadoAulaService service;

    public EstadoAulaDeleteRestController(EstadoAulaService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codesta}", "/{codesta}/deshabilitar"})
    public ResponseEntity<EstadoAulaEntity> deshabilitar(@PathVariable("codesta") Integer codesta) {
        return ResponseEntity.ok(service.deshabilitar(codesta));
    }
}
