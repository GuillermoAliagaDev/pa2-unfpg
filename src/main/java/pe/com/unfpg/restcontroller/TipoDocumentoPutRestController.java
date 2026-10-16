package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoDocumentoEntity;
import pe.com.unfpg.service.TipoDocumentoService;

@RestController
@RequestMapping("/api/tipodocumento")
public class TipoDocumentoPutRestController {
    private final TipoDocumentoService service;

    public TipoDocumentoPutRestController(TipoDocumentoService service) {
        this.service = service;
    }

    @PutMapping("/{codtipd}")
    public ResponseEntity<TipoDocumentoEntity> actualizar(
            @PathVariable("codtipd") Integer codtipd,
            @RequestBody TipoDocumentoEntity datos) {
        return ResponseEntity.ok(service.actualizar(codtipd, datos));
    }
}
