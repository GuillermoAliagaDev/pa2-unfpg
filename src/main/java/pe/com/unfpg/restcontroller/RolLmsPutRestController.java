package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.RolLmsEntity;
import pe.com.unfpg.service.RolLmsService;

@RestController
@RequestMapping("/api/rollms")
public class RolLmsPutRestController {
    private final RolLmsService service;

    public RolLmsPutRestController(RolLmsService service) {
        this.service = service;
    }

    @PutMapping("/{codroll}")
    public ResponseEntity<RolLmsEntity> actualizar(
            @PathVariable("codroll") Integer codroll,
            @RequestBody RolLmsEntity datos) {
        return ResponseEntity.ok(service.actualizar(codroll, datos));
    }
}
