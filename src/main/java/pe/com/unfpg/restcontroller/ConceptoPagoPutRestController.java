package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.ConceptoPagoEntity;
import pe.com.unfpg.service.ConceptoPagoService;

@RestController
@RequestMapping("/api/conceptopago")
public class ConceptoPagoPutRestController {
    private final ConceptoPagoService service;

    public ConceptoPagoPutRestController(ConceptoPagoService service) {
        this.service = service;
    }

    @PutMapping("/{codconp}")
    public ResponseEntity<ConceptoPagoEntity> actualizar(
            @PathVariable("codconp") Integer codconp,
            @RequestBody ConceptoPagoEntity datos) {
        return ResponseEntity.ok(service.actualizar(codconp, datos));
    }
}
