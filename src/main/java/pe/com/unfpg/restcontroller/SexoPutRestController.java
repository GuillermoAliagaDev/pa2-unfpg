package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.SexoEntity;
import pe.com.unfpg.service.SexoService;

@RestController
@RequestMapping("/api/sexo")
public class SexoPutRestController {
    private final SexoService service;

    public SexoPutRestController(SexoService service) {
        this.service = service;
    }

    @PutMapping("/{codsex}")
    public ResponseEntity<SexoEntity> actualizar(
            @PathVariable("codsex") Integer codsex,
            @RequestBody SexoEntity datos) {
        return ResponseEntity.ok(service.actualizar(codsex, datos));
    }
}
