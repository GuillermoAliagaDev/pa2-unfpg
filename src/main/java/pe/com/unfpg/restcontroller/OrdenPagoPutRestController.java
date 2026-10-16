package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.OrdenPagoEntity;
import pe.com.unfpg.service.OrdenPagoService;

@RestController
@RequestMapping("/api/ordenpago")
public class OrdenPagoPutRestController {
    private final OrdenPagoService service;
    public OrdenPagoPutRestController(OrdenPagoService service) { this.service = service; }

    @PutMapping("/{codordpag}")
    public ResponseEntity<OrdenPagoEntity> actualizar(@PathVariable("codordpag") Integer codordpag, @RequestBody OrdenPagoEntity datos) {
        return ResponseEntity.ok(service.actualizar(codordpag, datos));
    }
}
