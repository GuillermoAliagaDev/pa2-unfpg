package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DiaSemanaEntity;
import pe.com.unfpg.service.DiaSemanaService;

@RestController
@RequestMapping("/api/diasemana")
public class DiaSemanaDeleteRestController {
    private final DiaSemanaService service;

    public DiaSemanaDeleteRestController(DiaSemanaService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{coddias}", "/{coddias}/deshabilitar"})
    public ResponseEntity<DiaSemanaEntity> deshabilitar(@PathVariable("coddias") Integer coddias) {
        return ResponseEntity.ok(service.deshabilitar(coddias));
    }
}
