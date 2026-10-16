package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.MetodoPagoEntity;
import pe.com.unfpg.service.MetodoPagoService;

@RestController
@RequestMapping("/api/metodopago")
public class MetodoPagoPatchRestController {
    private final MetodoPagoService service;

    public MetodoPagoPatchRestController(MetodoPagoService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codmetp}", "/{codmetp}/habilitar"})
    public ResponseEntity<MetodoPagoEntity> habilitar(@PathVariable("codmetp") Integer codmetp) {
        return ResponseEntity.ok(service.habilitar(codmetp));
    }
}
