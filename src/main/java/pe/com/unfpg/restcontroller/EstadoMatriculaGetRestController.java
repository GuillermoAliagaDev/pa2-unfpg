package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoMatriculaEntity;
import pe.com.unfpg.service.EstadoMatriculaService;

@RestController
@RequestMapping("/api/estadomatricula")
public class EstadoMatriculaGetRestController {
    private final EstadoMatriculaService service;

    public EstadoMatriculaGetRestController(EstadoMatriculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<EstadoMatriculaEntity> listar() { return service.listar(); }

    @GetMapping("/{codestm}")
    public EstadoMatriculaEntity buscarPorId(@PathVariable("codestm") Integer codestm) {
        return service.buscarPorId(codestm);
    }
}
