package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.SexoEntity;
import pe.com.unfpg.service.SexoService;

@RestController
@RequestMapping("/api/sexo")
public class SexoDeleteRestController {
    private final SexoService service;

    public SexoDeleteRestController(SexoService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codsex}", "/{codsex}/deshabilitar"})
    public ResponseEntity<SexoEntity> deshabilitar(@PathVariable("codsex") Integer codsex) {
        return ResponseEntity.ok(service.deshabilitar(codsex));
    }
}
