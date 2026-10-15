package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.BloqueEntity;
import pe.com.unfpg.service.BloqueService;

@RestController
@RequestMapping("/api/bloque")
public class BloqueGetRestController {
    private final BloqueService service;

    public BloqueGetRestController(BloqueService service) {
        this.service = service;
    }

    @GetMapping
    public List<BloqueEntity> listar() { return service.listar(); }

    @GetMapping("/{codblo}")
    public BloqueEntity buscarPorId(@PathVariable("codblo") Integer codblo) {
        return service.buscarPorId(codblo);
    }
}
