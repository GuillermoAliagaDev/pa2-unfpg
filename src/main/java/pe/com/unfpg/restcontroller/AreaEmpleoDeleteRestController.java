package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.AreaEmpleoEntity;
import pe.com.unfpg.service.AreaEmpleoService;

@RestController
@RequestMapping("/api/areaempleo")
public class AreaEmpleoDeleteRestController {
    private final AreaEmpleoService service;

    public AreaEmpleoDeleteRestController(AreaEmpleoService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codare}", "/{codare}/deshabilitar"})
    public ResponseEntity<AreaEmpleoEntity> deshabilitar(@PathVariable("codare") Integer codare) {
        return ResponseEntity.ok(service.deshabilitar(codare));
    }
}
