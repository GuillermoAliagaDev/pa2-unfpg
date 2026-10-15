package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CalificacionEntity;
import pe.com.unfpg.service.CalificacionService;

@RestController
@RequestMapping("/api/calificacion")
public class CalificacionGetRestController {
    private final CalificacionService service;

    public CalificacionGetRestController(CalificacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<CalificacionEntity> listar() { return service.listar(); }

    @GetMapping("/{codcal}")
    public CalificacionEntity buscarPorId(@PathVariable("codcal") Integer codcal) {
        return service.buscarPorId(codcal);
    }
}
