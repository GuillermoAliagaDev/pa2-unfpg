package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PlanEstudioEntity;
import pe.com.unfpg.service.PlanEstudioService;

@RestController
@RequestMapping("/api/planestudio")
public class PlanEstudioDeleteRestController {
    private final PlanEstudioService service;

    public PlanEstudioDeleteRestController(PlanEstudioService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codpla}", "/{codpla}/deshabilitar"})
    public ResponseEntity<PlanEstudioEntity> deshabilitar(@PathVariable("codpla") Integer codpla) {
        return ResponseEntity.ok(service.deshabilitar(codpla));
    }
}
