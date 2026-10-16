package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.AreaEmpleoEntity;
import pe.com.unfpg.service.AreaEmpleoService;

@RestController
@RequestMapping("/api/areaempleo")
public class AreaEmpleoPatchRestController {
    private final AreaEmpleoService service;

    public AreaEmpleoPatchRestController(AreaEmpleoService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codare}", "/{codare}/habilitar"})
    public ResponseEntity<AreaEmpleoEntity> habilitar(@PathVariable("codare") Integer codare) {
        return ResponseEntity.ok(service.habilitar(codare));
    }
}
