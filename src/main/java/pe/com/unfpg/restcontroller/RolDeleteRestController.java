package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.RolEntity;
import pe.com.unfpg.service.RolService;

@RestController
@RequestMapping("/api/rol")
public class RolDeleteRestController {
    private final RolService service;

    public RolDeleteRestController(RolService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codrol}", "/{codrol}/deshabilitar"})
    public ResponseEntity<RolEntity> deshabilitar(@PathVariable("codrol") Integer codrol) {
        return ResponseEntity.ok(service.deshabilitar(codrol));
    }
}
