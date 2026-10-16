package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoCalificacionEntity;
import pe.com.unfpg.service.TipoCalificacionService;

@RestController
@RequestMapping("/api/tipocalificacion")
public class TipoCalificacionPatchRestController {
    private final TipoCalificacionService service;

    public TipoCalificacionPatchRestController(TipoCalificacionService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codtipc}", "/{codtipc}/habilitar"})
    public ResponseEntity<TipoCalificacionEntity> habilitar(@PathVariable("codtipc") Integer codtipc) {
        return ResponseEntity.ok(service.habilitar(codtipc));
    }
}
