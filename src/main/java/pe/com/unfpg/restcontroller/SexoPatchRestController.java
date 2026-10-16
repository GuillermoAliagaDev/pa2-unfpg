package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.SexoEntity;
import pe.com.unfpg.service.SexoService;

@RestController
@RequestMapping("/api/sexo")
public class SexoPatchRestController {
    private final SexoService service;

    public SexoPatchRestController(SexoService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codsex}", "/{codsex}/habilitar"})
    public ResponseEntity<SexoEntity> habilitar(@PathVariable("codsex") Integer codsex) {
        return ResponseEntity.ok(service.habilitar(codsex));
    }
}
