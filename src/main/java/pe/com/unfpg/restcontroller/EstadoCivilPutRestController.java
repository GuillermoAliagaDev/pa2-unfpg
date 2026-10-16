package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoCivilEntity;
import pe.com.unfpg.service.EstadoCivilService;

@RestController
@RequestMapping("/api/estadocivil")
public class EstadoCivilPutRestController {
    private final EstadoCivilService service;

    public EstadoCivilPutRestController(EstadoCivilService service) {
        this.service = service;
    }

    @PutMapping("/{codestc}")
    public ResponseEntity<EstadoCivilEntity> actualizar(
            @PathVariable("codestc") Integer codestc,
            @RequestBody EstadoCivilEntity datos) {
        return ResponseEntity.ok(service.actualizar(codestc, datos));
    }
}
