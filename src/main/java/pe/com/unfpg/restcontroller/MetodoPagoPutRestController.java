package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.MetodoPagoEntity;
import pe.com.unfpg.service.MetodoPagoService;

@RestController
@RequestMapping("/api/metodopago")
public class MetodoPagoPutRestController {
    private final MetodoPagoService service;

    public MetodoPagoPutRestController(MetodoPagoService service) {
        this.service = service;
    }

    @PutMapping("/{codmetp}")
    public ResponseEntity<MetodoPagoEntity> actualizar(
            @PathVariable("codmetp") Integer codmetp,
            @RequestBody MetodoPagoEntity datos) {
        return ResponseEntity.ok(service.actualizar(codmetp, datos));
    }
}
