package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.BloqueEntity;
import pe.com.unfpg.service.BloqueService;

@RestController
@RequestMapping("/api/bloque")
public class BloquePutRestController {
    private final BloqueService service;
    public BloquePutRestController(BloqueService service) { this.service = service; }

    @PutMapping("/{codblo}")
    public ResponseEntity<BloqueEntity> actualizar(@PathVariable("codblo") Integer codblo, @RequestBody BloqueEntity datos) {
        return ResponseEntity.ok(service.actualizar(codblo, datos));
    }
}
