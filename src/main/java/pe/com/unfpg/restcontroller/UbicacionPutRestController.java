package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.UbicacionEntity;
import pe.com.unfpg.service.UbicacionService;

@RestController
@RequestMapping("/api/ubicacion")
public class UbicacionPutRestController {
    private final UbicacionService service;

    public UbicacionPutRestController(UbicacionService service) {
        this.service = service;
    }

    @PutMapping("/{codubi}")
    public ResponseEntity<UbicacionEntity> actualizar(
            @PathVariable("codubi") Integer codubi,
            @RequestBody UbicacionEntity datos) {
        return ResponseEntity.ok(service.actualizar(codubi, datos));
    }
}
