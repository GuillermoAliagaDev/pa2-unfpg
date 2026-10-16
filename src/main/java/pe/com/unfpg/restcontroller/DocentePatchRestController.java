package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DocenteEntity;
import pe.com.unfpg.service.DocenteService;

@RestController
@RequestMapping("/api/docente")
public class DocentePatchRestController {
    private final DocenteService service;

    public DocentePatchRestController(DocenteService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{coddoc}", "/{coddoc}/habilitar"})
    public ResponseEntity<DocenteEntity> habilitar(@PathVariable("coddoc") Integer coddoc) {
        return ResponseEntity.ok(service.habilitar(coddoc));
    }
}
