package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TrasladoEntity;
import pe.com.unfpg.service.TrasladoService;

@RestController
@RequestMapping("/api/traslado")
public class TrasladoPatchRestController {
    private final TrasladoService service;

    public TrasladoPatchRestController(TrasladoService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codtra}", "/{codtra}/habilitar"})
    public ResponseEntity<TrasladoEntity> habilitar(@PathVariable("codtra") Integer codtra) {
        return ResponseEntity.ok(service.habilitar(codtra));
    }
}
