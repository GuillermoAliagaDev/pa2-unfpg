package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EvaluacionLmsEntity;
import pe.com.unfpg.service.EvaluacionLmsService;

@RestController
@RequestMapping("/api/evaluacionlms")
public class EvaluacionLmsPatchRestController {
    private final EvaluacionLmsService service;

    public EvaluacionLmsPatchRestController(EvaluacionLmsService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codeval}", "/{codeval}/habilitar"})
    public ResponseEntity<EvaluacionLmsEntity> habilitar(@PathVariable("codeval") Integer codeval) {
        return ResponseEntity.ok(service.habilitar(codeval));
    }
}
