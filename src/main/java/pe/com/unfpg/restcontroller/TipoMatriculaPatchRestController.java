package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoMatriculaEntity;
import pe.com.unfpg.service.TipoMatriculaService;

@RestController
@RequestMapping("/api/tipomatricula")
public class TipoMatriculaPatchRestController {
    private final TipoMatriculaService service;

    public TipoMatriculaPatchRestController(TipoMatriculaService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codtipm}", "/{codtipm}/habilitar"})
    public ResponseEntity<TipoMatriculaEntity> habilitar(@PathVariable("codtipm") Integer codtipm) {
        return ResponseEntity.ok(service.habilitar(codtipm));
    }
}
