package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.OrdenPagoEntity;
import pe.com.unfpg.service.OrdenPagoService;

@RestController
@RequestMapping("/api/ordenpago")
public class OrdenPagoDeleteRestController {
    private final OrdenPagoService service;

    public OrdenPagoDeleteRestController(OrdenPagoService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codordpag}", "/{codordpag}/deshabilitar"})
    public ResponseEntity<OrdenPagoEntity> deshabilitar(@PathVariable("codordpag") Integer codordpag) {
        return ResponseEntity.ok(service.deshabilitar(codordpag));
    }
}
