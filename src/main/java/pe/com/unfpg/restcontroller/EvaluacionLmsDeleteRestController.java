package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EvaluacionLmsEntity;
import pe.com.unfpg.service.EvaluacionLmsService;

@RestController
@RequestMapping("/api/evaluacionlms")
public class EvaluacionLmsDeleteRestController {
    private final EvaluacionLmsService service;

    public EvaluacionLmsDeleteRestController(EvaluacionLmsService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codeval}", "/{codeval}/deshabilitar"})
    public ResponseEntity<EvaluacionLmsEntity> deshabilitar(@PathVariable("codeval") Integer codeval) {
        return ResponseEntity.ok(service.deshabilitar(codeval));
    }
}
