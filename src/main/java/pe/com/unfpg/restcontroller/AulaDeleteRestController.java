package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.service.AulaService;

@RestController
@RequestMapping("/api/aula")
public class AulaDeleteRestController {
    private final AulaService service;

    public AulaDeleteRestController(AulaService service) {
        this.service = service;
    }

    @DeleteMapping("/{codaul}")
    public ResponseEntity<Void> eliminar(@PathVariable("codaul") Integer codaul) {
        service.eliminar(codaul);
        return ResponseEntity.noContent().build();
    }
}
