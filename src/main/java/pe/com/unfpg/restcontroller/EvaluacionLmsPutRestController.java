package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EvaluacionLmsEntity;
import pe.com.unfpg.service.EvaluacionLmsService;

@RestController
@RequestMapping("/api/evaluacionlms")
public class EvaluacionLmsPutRestController {
    private final EvaluacionLmsService service;
    public EvaluacionLmsPutRestController(EvaluacionLmsService service) { this.service = service; }

    @PutMapping("/{codeval}")
    public ResponseEntity<EvaluacionLmsEntity> actualizar(@PathVariable("codeval") Integer codeval, @RequestBody EvaluacionLmsEntity datos) {
        return ResponseEntity.ok(service.actualizar(codeval, datos));
    }
}
