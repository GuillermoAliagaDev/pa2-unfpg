package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PagoEntity;
import pe.com.unfpg.service.PagoService;

@RestController
@RequestMapping("/api/pago")
public class PagoPutRestController {
    private final PagoService service;
    public PagoPutRestController(PagoService service) { this.service = service; }

    @PutMapping("/{codpag}")
    public ResponseEntity<PagoEntity> actualizar(@PathVariable("codpag") Integer codpag, @RequestBody PagoEntity datos) {
        return ResponseEntity.ok(service.actualizar(codpag, datos));
    }
}
