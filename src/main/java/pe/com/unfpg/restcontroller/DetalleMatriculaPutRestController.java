package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DetalleMatriculaEntity;
import pe.com.unfpg.service.DetalleMatriculaService;

@RestController
@RequestMapping("/api/detallematricula")
public class DetalleMatriculaPutRestController {
    private final DetalleMatriculaService service;
    public DetalleMatriculaPutRestController(DetalleMatriculaService service) { this.service = service; }

    @PutMapping("/{coddet}")
    public ResponseEntity<DetalleMatriculaEntity> actualizar(@PathVariable("coddet") Integer coddet, @RequestBody DetalleMatriculaEntity datos) {
        return ResponseEntity.ok(service.actualizar(coddet, datos));
    }
}
