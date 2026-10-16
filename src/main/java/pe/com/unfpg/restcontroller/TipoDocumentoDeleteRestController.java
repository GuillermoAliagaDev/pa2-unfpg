package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoDocumentoEntity;
import pe.com.unfpg.service.TipoDocumentoService;

@RestController
@RequestMapping("/api/tipodocumento")
public class TipoDocumentoDeleteRestController {
    private final TipoDocumentoService service;

    public TipoDocumentoDeleteRestController(TipoDocumentoService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codtipd}", "/{codtipd}/deshabilitar"})
    public ResponseEntity<TipoDocumentoEntity> deshabilitar(@PathVariable("codtipd") Integer codtipd) {
        return ResponseEntity.ok(service.deshabilitar(codtipd));
    }
}
