package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.MetodoPagoEntity;
import pe.com.unfpg.service.MetodoPagoService;

@RestController
@RequestMapping("/api/metodopago")
public class MetodoPagoDeleteRestController {
    private final MetodoPagoService service;

    public MetodoPagoDeleteRestController(MetodoPagoService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codmetp}", "/{codmetp}/deshabilitar"})
    public ResponseEntity<MetodoPagoEntity> deshabilitar(@PathVariable("codmetp") Integer codmetp) {
        return ResponseEntity.ok(service.deshabilitar(codmetp));
    }
}
