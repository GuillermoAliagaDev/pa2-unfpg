package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoAulaEntity;
import pe.com.unfpg.service.TipoAulaService;

@RestController
@RequestMapping("/api/tipoaula")
public class TipoAulaPatchRestController {
    private final TipoAulaService service;

    public TipoAulaPatchRestController(TipoAulaService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codtipa}", "/{codtipa}/habilitar"})
    public ResponseEntity<TipoAulaEntity> habilitar(@PathVariable("codtipa") Integer codtipa) {
        return ResponseEntity.ok(service.habilitar(codtipa));
    }
}
