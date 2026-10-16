package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoPagoEntity;
import pe.com.unfpg.service.EstadoPagoService;

@RestController
@RequestMapping("/api/estadopago")
public class EstadoPagoPutRestController {
    private final EstadoPagoService service;

    public EstadoPagoPutRestController(EstadoPagoService service) {
        this.service = service;
    }

    @PutMapping("/{codestp}")
    public ResponseEntity<EstadoPagoEntity> actualizar(
            @PathVariable("codestp") Integer codestp,
            @RequestBody EstadoPagoEntity datos) {
        return ResponseEntity.ok(service.actualizar(codestp, datos));
    }
}
