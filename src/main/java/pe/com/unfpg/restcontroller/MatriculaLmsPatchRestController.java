package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.MatriculaLmsEntity;
import pe.com.unfpg.service.MatriculaLmsService;

@RestController
@RequestMapping("/api/matriculalms")
public class MatriculaLmsPatchRestController {
    private final MatriculaLmsService service;

    public MatriculaLmsPatchRestController(MatriculaLmsService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{nummatl}", "/{nummatl}/habilitar"})
    public ResponseEntity<MatriculaLmsEntity> habilitar(@PathVariable("nummatl") Integer nummatl) {
        return ResponseEntity.ok(service.habilitar(nummatl));
    }
}
