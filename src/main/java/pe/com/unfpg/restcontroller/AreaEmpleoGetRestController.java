package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.AreaEmpleoEntity;
import pe.com.unfpg.service.AreaEmpleoService;

@RestController
@RequestMapping("/api/areaempleo")
public class AreaEmpleoGetRestController {
    private final AreaEmpleoService service;

    public AreaEmpleoGetRestController(AreaEmpleoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AreaEmpleoEntity> listar() { return service.listar(); }

    @GetMapping("/{codare}")
    public AreaEmpleoEntity buscarPorId(@PathVariable("codare") Integer codare) {
        return service.buscarPorId(codare);
    }
}
