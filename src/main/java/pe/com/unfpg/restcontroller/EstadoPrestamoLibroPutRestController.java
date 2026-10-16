package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoPrestamoLibroEntity;
import pe.com.unfpg.service.EstadoPrestamoLibroService;

@RestController
@RequestMapping("/api/estadoprestamolibro")
public class EstadoPrestamoLibroPutRestController {
    private final EstadoPrestamoLibroService service;

    public EstadoPrestamoLibroPutRestController(EstadoPrestamoLibroService service) {
        this.service = service;
    }

    @PutMapping("/{codestl}")
    public ResponseEntity<EstadoPrestamoLibroEntity> actualizar(
            @PathVariable("codestl") Integer codestl,
            @RequestBody EstadoPrestamoLibroEntity datos) {
        return ResponseEntity.ok(service.actualizar(codestl, datos));
    }
}
