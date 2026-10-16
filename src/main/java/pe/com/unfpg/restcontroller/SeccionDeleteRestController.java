package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.service.SeccionService;

@RestController
@RequestMapping("/api/seccion")
public class SeccionDeleteRestController {
    private final SeccionService service;

    public SeccionDeleteRestController(SeccionService service) {
        this.service = service;
    }

    @DeleteMapping("/{codsec}")
    public ResponseEntity<Void> eliminar(@PathVariable("codsec") Integer codsec) {
        service.eliminar(codsec);
        return ResponseEntity.noContent().build();
    }
}
