package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.AulaEntity;
import pe.com.unfpg.service.AulaService;

@RestController
@RequestMapping("/api/aula")
public class AulaPutRestController {
    private final AulaService service;
    public AulaPutRestController(AulaService service) { this.service = service; }

    @PutMapping("/{codaul}")
    public ResponseEntity<AulaEntity> actualizar(@PathVariable("codaul") Integer codaul, @RequestBody AulaEntity datos) {
        return ResponseEntity.ok(service.actualizar(codaul, datos));
    }
}
