package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.RolLmsEntity;
import pe.com.unfpg.service.RolLmsService;

@RestController
@RequestMapping("/api/rollms")
public class RolLmsPatchRestController {
    private final RolLmsService service;

    public RolLmsPatchRestController(RolLmsService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codroll}", "/{codroll}/habilitar"})
    public ResponseEntity<RolLmsEntity> habilitar(@PathVariable("codroll") Integer codroll) {
        return ResponseEntity.ok(service.habilitar(codroll));
    }
}
