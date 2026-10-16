package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PlanEstudioEntity;
import pe.com.unfpg.service.PlanEstudioService;

@RestController
@RequestMapping("/api/planestudio")
public class PlanEstudioPutRestController {
    private final PlanEstudioService service;
    public PlanEstudioPutRestController(PlanEstudioService service) { this.service = service; }

    @PutMapping("/{codpla}")
    public ResponseEntity<PlanEstudioEntity> actualizar(@PathVariable("codpla") Integer codpla, @RequestBody PlanEstudioEntity datos) {
        return ResponseEntity.ok(service.actualizar(codpla, datos));
    }
}
