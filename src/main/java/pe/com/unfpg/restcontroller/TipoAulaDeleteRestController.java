package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoAulaEntity;
import pe.com.unfpg.service.TipoAulaService;

@RestController
@RequestMapping("/api/tipoaula")
public class TipoAulaDeleteRestController {
    private final TipoAulaService service;

    public TipoAulaDeleteRestController(TipoAulaService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codtipa}", "/{codtipa}/deshabilitar"})
    public ResponseEntity<TipoAulaEntity> deshabilitar(@PathVariable("codtipa") Integer codtipa) {
        return ResponseEntity.ok(service.deshabilitar(codtipa));
    }
}
