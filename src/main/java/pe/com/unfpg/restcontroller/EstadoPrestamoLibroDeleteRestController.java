package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoPrestamoLibroEntity;
import pe.com.unfpg.service.EstadoPrestamoLibroService;

@RestController
@RequestMapping("/api/estadoprestamolibro")
public class EstadoPrestamoLibroDeleteRestController {
    private final EstadoPrestamoLibroService service;

    public EstadoPrestamoLibroDeleteRestController(EstadoPrestamoLibroService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codestl}", "/{codestl}/deshabilitar"})
    public ResponseEntity<EstadoPrestamoLibroEntity> deshabilitar(@PathVariable("codestl") Integer codestl) {
        return ResponseEntity.ok(service.deshabilitar(codestl));
    }
}
