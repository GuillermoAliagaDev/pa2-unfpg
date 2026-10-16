package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DocenteEntity;
import pe.com.unfpg.service.DocenteService;

@RestController
@RequestMapping("/api/docente")
public class DocenteDeleteRestController {
    private final DocenteService service;

    public DocenteDeleteRestController(DocenteService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{coddoc}", "/{coddoc}/deshabilitar"})
    public ResponseEntity<DocenteEntity> deshabilitar(@PathVariable("coddoc") Integer coddoc) {
        return ResponseEntity.ok(service.deshabilitar(coddoc));
    }
}
