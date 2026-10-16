package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.RolEntity;
import pe.com.unfpg.service.RolService;

@RestController
@RequestMapping("/api/rol")
public class RolPatchRestController {
    private final RolService service;

    public RolPatchRestController(RolService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codrol}", "/{codrol}/habilitar"})
    public ResponseEntity<RolEntity> habilitar(@PathVariable("codrol") Integer codrol) {
        return ResponseEntity.ok(service.habilitar(codrol));
    }
}
