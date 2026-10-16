package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DocenteEntity;
import pe.com.unfpg.service.DocenteService;

@RestController
@RequestMapping("/api/docente")
public class DocentePutRestController {
    private final DocenteService service;
    public DocentePutRestController(DocenteService service) { this.service = service; }

    @PutMapping("/{coddoc}")
    public ResponseEntity<DocenteEntity> actualizar(@PathVariable("coddoc") Integer coddoc, @RequestBody DocenteEntity datos) {
        return ResponseEntity.ok(service.actualizar(coddoc, datos));
    }
}
