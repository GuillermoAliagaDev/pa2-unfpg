package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EjemplarLibroEntity;
import pe.com.unfpg.service.EjemplarLibroService;

@RestController
@RequestMapping("/api/ejemplarlibro")
public class EjemplarLibroPutRestController {
    private final EjemplarLibroService service;
    public EjemplarLibroPutRestController(EjemplarLibroService service) { this.service = service; }

    @PutMapping("/{codeje}")
    public ResponseEntity<EjemplarLibroEntity> actualizar(@PathVariable("codeje") Integer codeje, @RequestBody EjemplarLibroEntity datos) {
        return ResponseEntity.ok(service.actualizar(codeje, datos));
    }
}
