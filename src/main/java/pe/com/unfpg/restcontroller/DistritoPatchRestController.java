package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DistritoEntity;
import pe.com.unfpg.service.DistritoService;

@RestController
@RequestMapping("/api/distrito")
public class DistritoPatchRestController {
    private final DistritoService service;

    public DistritoPatchRestController(DistritoService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{coddis}", "/{coddis}/habilitar"})
    public ResponseEntity<DistritoEntity> habilitar(@PathVariable("coddis") Integer coddis) {
        return ResponseEntity.ok(service.habilitar(coddis));
    }
}
