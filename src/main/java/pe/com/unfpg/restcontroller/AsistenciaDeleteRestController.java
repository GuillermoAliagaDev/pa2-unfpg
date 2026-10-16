package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.service.AsistenciaService;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaDeleteRestController {
    private final AsistenciaService service;

    public AsistenciaDeleteRestController(AsistenciaService service) {
        this.service = service;
    }

    @DeleteMapping("/{codasis}")
    public ResponseEntity<Void> eliminar(@PathVariable("codasis") Integer codasis) {
        service.eliminar(codasis);
        return ResponseEntity.noContent().build();
    }
}
