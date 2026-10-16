package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.UbicacionEntity;
import pe.com.unfpg.service.UbicacionService;

@RestController
@RequestMapping("/api/ubicacion")
public class UbicacionPatchRestController {
    private final UbicacionService service;

    public UbicacionPatchRestController(UbicacionService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codubi}", "/{codubi}/habilitar"})
    public ResponseEntity<UbicacionEntity> habilitar(@PathVariable("codubi") Integer codubi) {
        return ResponseEntity.ok(service.habilitar(codubi));
    }
}
