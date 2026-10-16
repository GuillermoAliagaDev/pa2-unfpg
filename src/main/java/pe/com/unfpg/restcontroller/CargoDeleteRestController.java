package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CargoEntity;
import pe.com.unfpg.service.CargoService;

@RestController
@RequestMapping("/api/cargo")
public class CargoDeleteRestController {
    private final CargoService service;

    public CargoDeleteRestController(CargoService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codcar}", "/{codcar}/deshabilitar"})
    public ResponseEntity<CargoEntity> deshabilitar(@PathVariable("codcar") Integer codcar) {
        return ResponseEntity.ok(service.deshabilitar(codcar));
    }
}
