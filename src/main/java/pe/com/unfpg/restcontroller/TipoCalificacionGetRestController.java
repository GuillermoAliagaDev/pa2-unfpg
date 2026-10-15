package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoCalificacionEntity;
import pe.com.unfpg.service.TipoCalificacionService;

@RestController
@RequestMapping("/api/tipocalificacion")
public class TipoCalificacionGetRestController {
    private final TipoCalificacionService service;

    public TipoCalificacionGetRestController(TipoCalificacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoCalificacionEntity> listar() { return service.listar(); }

    @GetMapping("/{codtipc}")
    public TipoCalificacionEntity buscarPorId(@PathVariable("codtipc") Integer codtipc) {
        return service.buscarPorId(codtipc);
    }
}
