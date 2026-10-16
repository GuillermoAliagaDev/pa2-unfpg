package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoPagoEntity;
import pe.com.unfpg.service.EstadoPagoService;

@RestController
@RequestMapping("/api/estadopago")
public class EstadoPagoPatchRestController {
    private final EstadoPagoService service;

    public EstadoPagoPatchRestController(EstadoPagoService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codestp}", "/{codestp}/habilitar"})
    public ResponseEntity<EstadoPagoEntity> habilitar(@PathVariable("codestp") Integer codestp) {
        return ResponseEntity.ok(service.habilitar(codestp));
    }
}
