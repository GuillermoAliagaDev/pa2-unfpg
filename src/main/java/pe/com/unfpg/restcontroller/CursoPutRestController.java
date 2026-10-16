package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CursoEntity;
import pe.com.unfpg.service.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoPutRestController {
    private final CursoService service;
    public CursoPutRestController(CursoService service) { this.service = service; }

    @PutMapping("/{codcur}")
    public ResponseEntity<CursoEntity> actualizar(@PathVariable("codcur") Integer codcur, @RequestBody CursoEntity datos) {
        return ResponseEntity.ok(service.actualizar(codcur, datos));
    }
}
