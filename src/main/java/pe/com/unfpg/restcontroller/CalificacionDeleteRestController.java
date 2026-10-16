package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.service.CalificacionService;

@RestController
@RequestMapping("/api/calificacion")
public class CalificacionDeleteRestController {
    private final CalificacionService service;

    public CalificacionDeleteRestController(CalificacionService service) {
        this.service = service;
    }

    @DeleteMapping("/{codcal}")
    public ResponseEntity<Void> eliminar(@PathVariable("codcal") Integer codcal) {
        service.eliminar(codcal);
        return ResponseEntity.noContent().build();
    }
}
