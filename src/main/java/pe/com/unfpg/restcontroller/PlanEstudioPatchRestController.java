package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PlanEstudioEntity;
import pe.com.unfpg.service.PlanEstudioService;

@RestController
@RequestMapping("/api/planestudio")
public class PlanEstudioPatchRestController {
    private final PlanEstudioService service;

    public PlanEstudioPatchRestController(PlanEstudioService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codpla}", "/{codpla}/habilitar"})
    public ResponseEntity<PlanEstudioEntity> habilitar(@PathVariable("codpla") Integer codpla) {
        return ResponseEntity.ok(service.habilitar(codpla));
    }
}
