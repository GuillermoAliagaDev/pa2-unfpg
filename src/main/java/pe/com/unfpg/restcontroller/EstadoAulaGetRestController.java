package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoAulaEntity;
import pe.com.unfpg.service.EstadoAulaService;

@RestController
@RequestMapping("/api/estadoaula")
public class EstadoAulaGetRestController {
    private final EstadoAulaService service;

    public EstadoAulaGetRestController(EstadoAulaService service) {
        this.service = service;
    }

    @GetMapping
    public List<EstadoAulaEntity> listar() { return service.listar(); }

    @GetMapping("/{codesta}")
    public EstadoAulaEntity buscarPorId(@PathVariable("codesta") Integer codesta) {
        return service.buscarPorId(codesta);
    }
}
