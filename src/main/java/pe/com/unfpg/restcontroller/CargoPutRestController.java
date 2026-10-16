package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CargoEntity;
import pe.com.unfpg.service.CargoService;

@RestController
@RequestMapping("/api/cargo")
public class CargoPutRestController {
    private final CargoService service;

    public CargoPutRestController(CargoService service) {
        this.service = service;
    }

    @PutMapping("/{codcar}")
    public ResponseEntity<CargoEntity> actualizar(
            @PathVariable("codcar") Integer codcar,
            @RequestBody CargoEntity datos) {
        return ResponseEntity.ok(service.actualizar(codcar, datos));
    }
}
