package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoCivilEntity;
import pe.com.unfpg.service.EstadoCivilService;

@RestController
@RequestMapping("/api/estadocivil")
public class EstadoCivilPatchRestController {
    private final EstadoCivilService service;

    public EstadoCivilPatchRestController(EstadoCivilService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codestc}", "/{codestc}/habilitar"})
    public ResponseEntity<EstadoCivilEntity> habilitar(@PathVariable("codestc") Integer codestc) {
        return ResponseEntity.ok(service.habilitar(codestc));
    }
}
