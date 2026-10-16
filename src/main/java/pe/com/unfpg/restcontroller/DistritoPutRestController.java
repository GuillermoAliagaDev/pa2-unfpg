package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DistritoEntity;
import pe.com.unfpg.service.DistritoService;

@RestController
@RequestMapping("/api/distrito")
public class DistritoPutRestController {
    private final DistritoService service;

    public DistritoPutRestController(DistritoService service) {
        this.service = service;
    }

    @PutMapping("/{coddis}")
    public ResponseEntity<DistritoEntity> actualizar(
            @PathVariable("coddis") Integer coddis,
            @RequestBody DistritoEntity datos) {
        return ResponseEntity.ok(service.actualizar(coddis, datos));
    }
}
