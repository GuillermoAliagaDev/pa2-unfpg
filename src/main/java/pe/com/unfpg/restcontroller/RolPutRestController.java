package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.RolEntity;
import pe.com.unfpg.service.RolService;

@RestController
@RequestMapping("/api/rol")
public class RolPutRestController {
    private final RolService service;

    public RolPutRestController(RolService service) {
        this.service = service;
    }

    @PutMapping("/{codrol}")
    public ResponseEntity<RolEntity> actualizar(
            @PathVariable("codrol") Integer codrol,
            @RequestBody RolEntity datos) {
        return ResponseEntity.ok(service.actualizar(codrol, datos));
    }
}
