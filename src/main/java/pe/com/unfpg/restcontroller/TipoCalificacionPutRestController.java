package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoCalificacionEntity;
import pe.com.unfpg.service.TipoCalificacionService;

@RestController
@RequestMapping("/api/tipocalificacion")
public class TipoCalificacionPutRestController {
    private final TipoCalificacionService service;

    public TipoCalificacionPutRestController(TipoCalificacionService service) {
        this.service = service;
    }

    @PutMapping("/{codtipc}")
    public ResponseEntity<TipoCalificacionEntity> actualizar(
            @PathVariable("codtipc") Integer codtipc,
            @RequestBody TipoCalificacionEntity datos) {
        return ResponseEntity.ok(service.actualizar(codtipc, datos));
    }
}
