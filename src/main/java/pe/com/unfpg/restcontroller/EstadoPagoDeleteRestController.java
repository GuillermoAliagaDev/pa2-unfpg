package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoPagoEntity;
import pe.com.unfpg.service.EstadoPagoService;

@RestController
@RequestMapping("/api/estadopago")
public class EstadoPagoDeleteRestController {
    private final EstadoPagoService service;

    public EstadoPagoDeleteRestController(EstadoPagoService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codestp}", "/{codestp}/deshabilitar"})
    public ResponseEntity<EstadoPagoEntity> deshabilitar(@PathVariable("codestp") Integer codestp) {
        return ResponseEntity.ok(service.deshabilitar(codestp));
    }
}
