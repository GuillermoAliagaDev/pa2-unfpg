package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.service.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoDeleteRestController {
    private final CursoService service;

    public CursoDeleteRestController(CursoService service) {
        this.service = service;
    }

    @DeleteMapping("/{codcur}")
    public ResponseEntity<Void> eliminar(@PathVariable("codcur") Integer codcur) {
        service.eliminar(codcur);
        return ResponseEntity.noContent().build();
    }
}
