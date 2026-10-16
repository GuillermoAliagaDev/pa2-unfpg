package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CargoEntity;
import pe.com.unfpg.service.CargoService;

@RestController
@RequestMapping("/api/cargo")
public class CargoPatchRestController {
    private final CargoService service;

    public CargoPatchRestController(CargoService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codcar}", "/{codcar}/habilitar"})
    public ResponseEntity<CargoEntity> habilitar(@PathVariable("codcar") Integer codcar) {
        return ResponseEntity.ok(service.habilitar(codcar));
    }
}
