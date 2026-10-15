package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoCivilEntity;
import pe.com.unfpg.service.EstadoCivilService;

@RestController
@RequestMapping("/api/estadocivil")
public class EstadoCivilGetRestController {
    private final EstadoCivilService service;

    public EstadoCivilGetRestController(EstadoCivilService service) {
        this.service = service;
    }

    @GetMapping
    public List<EstadoCivilEntity> listar() { return service.listar(); }

    @GetMapping("/{codestc}")
    public EstadoCivilEntity buscarPorId(@PathVariable("codestc") Integer codestc) {
        return service.buscarPorId(codestc);
    }
}
