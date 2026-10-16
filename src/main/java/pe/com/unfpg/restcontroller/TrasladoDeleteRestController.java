package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TrasladoEntity;
import pe.com.unfpg.service.TrasladoService;

@RestController
@RequestMapping("/api/traslado")
public class TrasladoDeleteRestController {
    private final TrasladoService service;

    public TrasladoDeleteRestController(TrasladoService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codtra}", "/{codtra}/deshabilitar"})
    public ResponseEntity<TrasladoEntity> deshabilitar(@PathVariable("codtra") Integer codtra) {
        return ResponseEntity.ok(service.deshabilitar(codtra));
    }
}
