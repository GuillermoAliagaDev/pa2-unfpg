package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.LibroEntity;
import pe.com.unfpg.service.LibroService;

@RestController
@RequestMapping("/api/libro")
public class LibroPutRestController {
    private final LibroService service;
    public LibroPutRestController(LibroService service) { this.service = service; }

    @PutMapping("/{codlib}")
    public ResponseEntity<LibroEntity> actualizar(@PathVariable("codlib") Integer codlib, @RequestBody LibroEntity datos) {
        return ResponseEntity.ok(service.actualizar(codlib, datos));
    }
}
