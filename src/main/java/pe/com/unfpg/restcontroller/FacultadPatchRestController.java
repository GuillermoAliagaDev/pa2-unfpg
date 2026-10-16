package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.FacultadEntity;
import pe.com.unfpg.service.FacultadService;

@RestController
@RequestMapping("/api/facultad")
public class FacultadPatchRestController {
    private final FacultadService service;

    public FacultadPatchRestController(FacultadService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codfac}", "/{codfac}/habilitar"})
    public ResponseEntity<FacultadEntity> habilitar(@PathVariable("codfac") Integer codfac) {
        return ResponseEntity.ok(service.habilitar(codfac));
    }
}
