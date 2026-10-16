package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DiaSemanaEntity;
import pe.com.unfpg.service.DiaSemanaService;

@RestController
@RequestMapping("/api/diasemana")
public class DiaSemanaPatchRestController {
    private final DiaSemanaService service;

    public DiaSemanaPatchRestController(DiaSemanaService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{coddias}", "/{coddias}/habilitar"})
    public ResponseEntity<DiaSemanaEntity> habilitar(@PathVariable("coddias") Integer coddias) {
        return ResponseEntity.ok(service.habilitar(coddias));
    }
}
