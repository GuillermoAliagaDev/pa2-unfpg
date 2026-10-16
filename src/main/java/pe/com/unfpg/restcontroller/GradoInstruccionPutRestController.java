package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.GradoInstruccionEntity;
import pe.com.unfpg.service.GradoInstruccionService;

@RestController
@RequestMapping("/api/gradoinstruccion")
public class GradoInstruccionPutRestController {
    private final GradoInstruccionService service;

    public GradoInstruccionPutRestController(GradoInstruccionService service) {
        this.service = service;
    }

    @PutMapping("/{codgrai}")
    public ResponseEntity<GradoInstruccionEntity> actualizar(
            @PathVariable("codgrai") Integer codgrai,
            @RequestBody GradoInstruccionEntity datos) {
        return ResponseEntity.ok(service.actualizar(codgrai, datos));
    }
}
