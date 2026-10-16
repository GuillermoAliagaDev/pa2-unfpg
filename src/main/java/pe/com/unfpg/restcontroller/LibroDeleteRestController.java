package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.LibroEntity;
import pe.com.unfpg.service.LibroService;

@RestController
@RequestMapping("/api/libro")
public class LibroDeleteRestController {
    private final LibroService service;

    public LibroDeleteRestController(LibroService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codlib}", "/{codlib}/deshabilitar"})
    public ResponseEntity<LibroEntity> deshabilitar(@PathVariable("codlib") Integer codlib) {
        return ResponseEntity.ok(service.deshabilitar(codlib));
    }
}
