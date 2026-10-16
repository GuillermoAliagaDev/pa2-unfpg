package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.MatriculaLmsEntity;
import pe.com.unfpg.service.MatriculaLmsService;

@RestController
@RequestMapping("/api/matriculalms")
public class MatriculaLmsDeleteRestController {
    private final MatriculaLmsService service;

    public MatriculaLmsDeleteRestController(MatriculaLmsService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{nummatl}", "/{nummatl}/deshabilitar"})
    public ResponseEntity<MatriculaLmsEntity> deshabilitar(@PathVariable("nummatl") Integer nummatl) {
        return ResponseEntity.ok(service.deshabilitar(nummatl));
    }
}
