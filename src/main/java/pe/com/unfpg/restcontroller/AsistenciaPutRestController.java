package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.AsistenciaEntity;
import pe.com.unfpg.service.AsistenciaService;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaPutRestController {
    private final AsistenciaService service;
    public AsistenciaPutRestController(AsistenciaService service) { this.service = service; }

    @PutMapping("/{codasis}")
    public ResponseEntity<AsistenciaEntity> actualizar(@PathVariable("codasis") Integer codasis, @RequestBody AsistenciaEntity datos) {
        return ResponseEntity.ok(service.actualizar(codasis, datos));
    }
}
