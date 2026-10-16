package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.RolLmsEntity;
import pe.com.unfpg.service.RolLmsService;

@RestController
@RequestMapping("/api/rollms")
public class RolLmsDeleteRestController {
    private final RolLmsService service;

    public RolLmsDeleteRestController(RolLmsService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codroll}", "/{codroll}/deshabilitar"})
    public ResponseEntity<RolLmsEntity> deshabilitar(@PathVariable("codroll") Integer codroll) {
        return ResponseEntity.ok(service.deshabilitar(codroll));
    }
}
