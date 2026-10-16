package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoCivilEntity;
import pe.com.unfpg.service.EstadoCivilService;

@RestController
@RequestMapping("/api/estadocivil")
public class EstadoCivilDeleteRestController {
    private final EstadoCivilService service;

    public EstadoCivilDeleteRestController(EstadoCivilService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codestc}", "/{codestc}/deshabilitar"})
    public ResponseEntity<EstadoCivilEntity> deshabilitar(@PathVariable("codestc") Integer codestc) {
        return ResponseEntity.ok(service.deshabilitar(codestc));
    }
}
