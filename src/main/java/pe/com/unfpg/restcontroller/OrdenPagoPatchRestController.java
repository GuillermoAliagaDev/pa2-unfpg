package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.OrdenPagoEntity;
import pe.com.unfpg.service.OrdenPagoService;

@RestController
@RequestMapping("/api/ordenpago")
public class OrdenPagoPatchRestController {
    private final OrdenPagoService service;

    public OrdenPagoPatchRestController(OrdenPagoService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codordpag}", "/{codordpag}/habilitar"})
    public ResponseEntity<OrdenPagoEntity> habilitar(@PathVariable("codordpag") Integer codordpag) {
        return ResponseEntity.ok(service.habilitar(codordpag));
    }
}
