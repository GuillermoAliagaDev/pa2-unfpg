package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.MatriculaLmsEntity;
import pe.com.unfpg.service.MatriculaLmsService;

@RestController
@RequestMapping("/api/matriculalms")
public class MatriculaLmsPutRestController {
    private final MatriculaLmsService service;
    public MatriculaLmsPutRestController(MatriculaLmsService service) { this.service = service; }

    @PutMapping("/{nummatl}")
    public ResponseEntity<MatriculaLmsEntity> actualizar(@PathVariable("nummatl") Integer nummatl, @RequestBody MatriculaLmsEntity datos) {
        return ResponseEntity.ok(service.actualizar(nummatl, datos));
    }
}
