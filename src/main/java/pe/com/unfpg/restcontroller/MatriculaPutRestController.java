package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.MatriculaEntity;
import pe.com.unfpg.service.MatriculaService;

@RestController
@RequestMapping("/api/matricula")
public class MatriculaPutRestController {
    private final MatriculaService service;
    public MatriculaPutRestController(MatriculaService service) { this.service = service; }

    @PutMapping("/{nummat}")
    public ResponseEntity<MatriculaEntity> actualizar(@PathVariable("nummat") Integer nummat, @RequestBody MatriculaEntity datos) {
        return ResponseEntity.ok(service.actualizar(nummat, datos));
    }
}
