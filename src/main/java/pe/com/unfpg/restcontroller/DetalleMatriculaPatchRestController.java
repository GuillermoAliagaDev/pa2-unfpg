package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DetalleMatriculaEntity;
import pe.com.unfpg.service.DetalleMatriculaService;

@RestController
@RequestMapping("/api/detallematricula")
public class DetalleMatriculaPatchRestController {
    private final DetalleMatriculaService service;

    public DetalleMatriculaPatchRestController(DetalleMatriculaService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{coddet}", "/{coddet}/habilitar"})
    public ResponseEntity<DetalleMatriculaEntity> habilitar(@PathVariable("coddet") Integer coddet) {
        return ResponseEntity.ok(service.habilitar(coddet));
    }
}
