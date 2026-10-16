package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoCalificacionEntity;
import pe.com.unfpg.service.TipoCalificacionService;

@RestController
@RequestMapping("/api/tipocalificacion")
public class TipoCalificacionDeleteRestController {
    private final TipoCalificacionService service;

    public TipoCalificacionDeleteRestController(TipoCalificacionService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codtipc}", "/{codtipc}/deshabilitar"})
    public ResponseEntity<TipoCalificacionEntity> deshabilitar(@PathVariable("codtipc") Integer codtipc) {
        return ResponseEntity.ok(service.deshabilitar(codtipc));
    }
}
