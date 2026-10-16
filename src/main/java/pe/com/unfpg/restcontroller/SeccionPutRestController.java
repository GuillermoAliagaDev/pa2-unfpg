package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.SeccionEntity;
import pe.com.unfpg.service.SeccionService;

@RestController
@RequestMapping("/api/seccion")
public class SeccionPutRestController {
    private final SeccionService service;
    public SeccionPutRestController(SeccionService service) { this.service = service; }

    @PutMapping("/{codsec}")
    public ResponseEntity<SeccionEntity> actualizar(@PathVariable("codsec") Integer codsec, @RequestBody SeccionEntity datos) {
        return ResponseEntity.ok(service.actualizar(codsec, datos));
    }
}
