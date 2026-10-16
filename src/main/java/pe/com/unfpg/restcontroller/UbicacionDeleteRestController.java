package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.UbicacionEntity;
import pe.com.unfpg.service.UbicacionService;

@RestController
@RequestMapping("/api/ubicacion")
public class UbicacionDeleteRestController {
    private final UbicacionService service;

    public UbicacionDeleteRestController(UbicacionService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codubi}", "/{codubi}/deshabilitar"})
    public ResponseEntity<UbicacionEntity> deshabilitar(@PathVariable("codubi") Integer codubi) {
        return ResponseEntity.ok(service.deshabilitar(codubi));
    }
}
