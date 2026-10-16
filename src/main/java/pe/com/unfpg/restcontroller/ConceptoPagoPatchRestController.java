package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.ConceptoPagoEntity;
import pe.com.unfpg.service.ConceptoPagoService;

@RestController
@RequestMapping("/api/conceptopago")
public class ConceptoPagoPatchRestController {
    private final ConceptoPagoService service;

    public ConceptoPagoPatchRestController(ConceptoPagoService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codconp}", "/{codconp}/habilitar"})
    public ResponseEntity<ConceptoPagoEntity> habilitar(@PathVariable("codconp") Integer codconp) {
        return ResponseEntity.ok(service.habilitar(codconp));
    }
}
