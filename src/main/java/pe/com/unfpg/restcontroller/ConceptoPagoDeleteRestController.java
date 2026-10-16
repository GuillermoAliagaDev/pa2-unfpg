package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.ConceptoPagoEntity;
import pe.com.unfpg.service.ConceptoPagoService;

@RestController
@RequestMapping("/api/conceptopago")
public class ConceptoPagoDeleteRestController {
    private final ConceptoPagoService service;

    public ConceptoPagoDeleteRestController(ConceptoPagoService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codconp}", "/{codconp}/deshabilitar"})
    public ResponseEntity<ConceptoPagoEntity> deshabilitar(@PathVariable("codconp") Integer codconp) {
        return ResponseEntity.ok(service.deshabilitar(codconp));
    }
}
