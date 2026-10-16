package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CalificacionEntity;
import pe.com.unfpg.service.CalificacionService;

@RestController
@RequestMapping("/api/calificacion")
public class CalificacionPutRestController {
    private final CalificacionService service;
    public CalificacionPutRestController(CalificacionService service) { this.service = service; }

    @PutMapping("/{codcal}")
    public ResponseEntity<CalificacionEntity> actualizar(@PathVariable("codcal") Integer codcal, @RequestBody CalificacionEntity datos) {
        return ResponseEntity.ok(service.actualizar(codcal, datos));
    }
}
