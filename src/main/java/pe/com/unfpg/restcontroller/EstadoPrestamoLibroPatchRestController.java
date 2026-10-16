package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoPrestamoLibroEntity;
import pe.com.unfpg.service.EstadoPrestamoLibroService;

@RestController
@RequestMapping("/api/estadoprestamolibro")
public class EstadoPrestamoLibroPatchRestController {
    private final EstadoPrestamoLibroService service;

    public EstadoPrestamoLibroPatchRestController(EstadoPrestamoLibroService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codestl}", "/{codestl}/habilitar"})
    public ResponseEntity<EstadoPrestamoLibroEntity> habilitar(@PathVariable("codestl") Integer codestl) {
        return ResponseEntity.ok(service.habilitar(codestl));
    }
}
