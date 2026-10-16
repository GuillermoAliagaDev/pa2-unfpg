package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.FacultadEntity;
import pe.com.unfpg.service.FacultadService;

@RestController
@RequestMapping("/api/facultad")
public class FacultadDeleteRestController {
    private final FacultadService service;

    public FacultadDeleteRestController(FacultadService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codfac}", "/{codfac}/deshabilitar"})
    public ResponseEntity<FacultadEntity> deshabilitar(@PathVariable("codfac") Integer codfac) {
        return ResponseEntity.ok(service.deshabilitar(codfac));
    }
}
