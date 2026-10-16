package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DistritoEntity;
import pe.com.unfpg.service.DistritoService;

@RestController
@RequestMapping("/api/distrito")
public class DistritoDeleteRestController {
    private final DistritoService service;

    public DistritoDeleteRestController(DistritoService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{coddis}", "/{coddis}/deshabilitar"})
    public ResponseEntity<DistritoEntity> deshabilitar(@PathVariable("coddis") Integer coddis) {
        return ResponseEntity.ok(service.deshabilitar(coddis));
    }
}
