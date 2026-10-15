package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TrasladoEntity;
import pe.com.unfpg.service.TrasladoService;

@RestController
@RequestMapping("/api/traslado")
public class TrasladoGetRestController {
    private final TrasladoService service;

    public TrasladoGetRestController(TrasladoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TrasladoEntity> listar() { return service.listar(); }

    @GetMapping("/{codtra}")
    public TrasladoEntity buscarPorId(@PathVariable("codtra") Integer codtra) {
        return service.buscarPorId(codtra);
    }
}
