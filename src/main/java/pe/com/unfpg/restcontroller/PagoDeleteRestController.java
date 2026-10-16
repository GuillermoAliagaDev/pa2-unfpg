package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PagoEntity;
import pe.com.unfpg.service.PagoService;

@RestController
@RequestMapping("/api/pago")
public class PagoDeleteRestController {
    private final PagoService service;

    public PagoDeleteRestController(PagoService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codpag}", "/{codpag}/deshabilitar"})
    public ResponseEntity<PagoEntity> deshabilitar(@PathVariable("codpag") Integer codpag) {
        return ResponseEntity.ok(service.deshabilitar(codpag));
    }
}
