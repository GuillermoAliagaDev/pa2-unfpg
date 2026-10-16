package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DiaSemanaEntity;
import pe.com.unfpg.service.DiaSemanaService;

@RestController
@RequestMapping("/api/diasemana")
public class DiaSemanaPutRestController {
    private final DiaSemanaService service;

    public DiaSemanaPutRestController(DiaSemanaService service) {
        this.service = service;
    }

    @PutMapping("/{coddias}")
    public ResponseEntity<DiaSemanaEntity> actualizar(
            @PathVariable("coddias") Integer coddias,
            @RequestBody DiaSemanaEntity datos) {
        return ResponseEntity.ok(service.actualizar(coddias, datos));
    }
}
