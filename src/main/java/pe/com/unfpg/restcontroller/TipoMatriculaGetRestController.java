package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoMatriculaEntity;
import pe.com.unfpg.service.TipoMatriculaService;

@RestController
@RequestMapping("/api/tipomatricula")
public class TipoMatriculaGetRestController {
    private final TipoMatriculaService service;

    public TipoMatriculaGetRestController(TipoMatriculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoMatriculaEntity> listar() { return service.listar(); }

    @GetMapping("/{codtipm}")
    public TipoMatriculaEntity buscarPorId(@PathVariable("codtipm") Integer codtipm) {
        return service.buscarPorId(codtipm);
    }
}
