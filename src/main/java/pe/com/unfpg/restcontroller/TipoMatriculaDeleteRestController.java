package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoMatriculaEntity;
import pe.com.unfpg.service.TipoMatriculaService;

@RestController
@RequestMapping("/api/tipomatricula")
public class TipoMatriculaDeleteRestController {
    private final TipoMatriculaService service;

    public TipoMatriculaDeleteRestController(TipoMatriculaService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codtipm}", "/{codtipm}/deshabilitar"})
    public ResponseEntity<TipoMatriculaEntity> deshabilitar(@PathVariable("codtipm") Integer codtipm) {
        return ResponseEntity.ok(service.deshabilitar(codtipm));
    }
}
