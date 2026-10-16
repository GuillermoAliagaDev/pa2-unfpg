package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PagoEntity;
import pe.com.unfpg.service.PagoService;

@RestController
@RequestMapping("/api/pago")
public class PagoPatchRestController {
    private final PagoService service;

    public PagoPatchRestController(PagoService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codpag}", "/{codpag}/habilitar"})
    public ResponseEntity<PagoEntity> habilitar(@PathVariable("codpag") Integer codpag) {
        return ResponseEntity.ok(service.habilitar(codpag));
    }
}
