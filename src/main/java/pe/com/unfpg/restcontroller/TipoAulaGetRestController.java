package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoAulaEntity;
import pe.com.unfpg.service.TipoAulaService;

@RestController
@RequestMapping("/api/tipoaula")
public class TipoAulaGetRestController {
    private final TipoAulaService service;

    public TipoAulaGetRestController(TipoAulaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoAulaEntity> listar() { return service.listar(); }

    @GetMapping("/{codtipa}")
    public TipoAulaEntity buscarPorId(@PathVariable("codtipa") Integer codtipa) {
        return service.buscarPorId(codtipa);
    }
}
