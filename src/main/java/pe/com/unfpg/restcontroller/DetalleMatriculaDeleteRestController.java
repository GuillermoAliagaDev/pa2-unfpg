package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DetalleMatriculaEntity;
import pe.com.unfpg.service.DetalleMatriculaService;

@RestController
@RequestMapping("/api/detallematricula")
public class DetalleMatriculaDeleteRestController {
    private final DetalleMatriculaService service;

    public DetalleMatriculaDeleteRestController(DetalleMatriculaService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{coddet}", "/{coddet}/deshabilitar"})
    public ResponseEntity<DetalleMatriculaEntity> deshabilitar(@PathVariable("coddet") Integer coddet) {
        return ResponseEntity.ok(service.deshabilitar(coddet));
    }
}
