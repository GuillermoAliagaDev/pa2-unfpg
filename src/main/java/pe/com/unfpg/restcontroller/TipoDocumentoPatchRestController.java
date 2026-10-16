package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoDocumentoEntity;
import pe.com.unfpg.service.TipoDocumentoService;

@RestController
@RequestMapping("/api/tipodocumento")
public class TipoDocumentoPatchRestController {
    private final TipoDocumentoService service;

    public TipoDocumentoPatchRestController(TipoDocumentoService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codtipd}", "/{codtipd}/habilitar"})
    public ResponseEntity<TipoDocumentoEntity> habilitar(@PathVariable("codtipd") Integer codtipd) {
        return ResponseEntity.ok(service.habilitar(codtipd));
    }
}
