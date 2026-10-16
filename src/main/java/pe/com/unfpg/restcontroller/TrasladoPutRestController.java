package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TrasladoEntity;
import pe.com.unfpg.service.TrasladoService;

@RestController
@RequestMapping("/api/traslado")
public class TrasladoPutRestController {
    private final TrasladoService service;
    public TrasladoPutRestController(TrasladoService service) { this.service = service; }

    @PutMapping("/{codtra}")
    public ResponseEntity<TrasladoEntity> actualizar(@PathVariable("codtra") Integer codtra, @RequestBody TrasladoEntity datos) {
        return ResponseEntity.ok(service.actualizar(codtra, datos));
    }
}
