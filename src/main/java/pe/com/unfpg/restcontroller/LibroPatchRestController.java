package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.LibroEntity;
import pe.com.unfpg.service.LibroService;

@RestController
@RequestMapping("/api/libro")
public class LibroPatchRestController {
    private final LibroService service;

    public LibroPatchRestController(LibroService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codlib}", "/{codlib}/habilitar"})
    public ResponseEntity<LibroEntity> habilitar(@PathVariable("codlib") Integer codlib) {
        return ResponseEntity.ok(service.habilitar(codlib));
    }
}
