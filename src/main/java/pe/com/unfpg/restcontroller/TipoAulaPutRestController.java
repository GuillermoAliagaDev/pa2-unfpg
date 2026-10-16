package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoAulaEntity;
import pe.com.unfpg.service.TipoAulaService;

@RestController
@RequestMapping("/api/tipoaula")
public class TipoAulaPutRestController {
    private final TipoAulaService service;

    public TipoAulaPutRestController(TipoAulaService service) {
        this.service = service;
    }

    @PutMapping("/{codtipa}")
    public ResponseEntity<TipoAulaEntity> actualizar(
            @PathVariable("codtipa") Integer codtipa,
            @RequestBody TipoAulaEntity datos) {
        return ResponseEntity.ok(service.actualizar(codtipa, datos));
    }
}
