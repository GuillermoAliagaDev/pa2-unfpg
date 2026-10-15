package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoPrestamoLibroEntity;
import pe.com.unfpg.service.EstadoPrestamoLibroService;

@RestController
@RequestMapping("/api/estadoprestamolibro")
public class EstadoPrestamoLibroGetRestController {
    private final EstadoPrestamoLibroService service;

    public EstadoPrestamoLibroGetRestController(EstadoPrestamoLibroService service) {
        this.service = service;
    }

    @GetMapping
    public List<EstadoPrestamoLibroEntity> listar() { return service.listar(); }

    @GetMapping("/{codestl}")
    public EstadoPrestamoLibroEntity buscarPorId(@PathVariable("codestl") Integer codestl) {
        return service.buscarPorId(codestl);
    }
}
