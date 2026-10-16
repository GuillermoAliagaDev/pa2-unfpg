package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.BloqueEntity;
import pe.com.unfpg.service.BloqueService;

@RestController
@RequestMapping("/api/bloque")
public class BloquePatchRestController {
    private final BloqueService service;

    public BloquePatchRestController(BloqueService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codblo}", "/{codblo}/habilitar"})
    public ResponseEntity<BloqueEntity> habilitar(@PathVariable("codblo") Integer codblo) {
        return ResponseEntity.ok(service.habilitar(codblo));
    }
}
