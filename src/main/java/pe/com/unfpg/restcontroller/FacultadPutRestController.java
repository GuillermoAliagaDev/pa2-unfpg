package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.FacultadEntity;
import pe.com.unfpg.service.FacultadService;

@RestController
@RequestMapping("/api/facultad")
public class FacultadPutRestController {
    private final FacultadService service;
    public FacultadPutRestController(FacultadService service) { this.service = service; }

    @PutMapping("/{codfac}")
    public ResponseEntity<FacultadEntity> actualizar(@PathVariable("codfac") Integer codfac, @RequestBody FacultadEntity datos) {
        return ResponseEntity.ok(service.actualizar(codfac, datos));
    }
}
