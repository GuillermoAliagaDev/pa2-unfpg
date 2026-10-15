package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.AulaEntity;
import pe.com.unfpg.service.AulaService;

@RestController
@RequestMapping("/api/aula")
public class AulaGetRestController {
    private final AulaService service;

    public AulaGetRestController(AulaService service) {
        this.service = service;
    }

    @GetMapping
    public List<AulaEntity> listar() { return service.listar(); }

    @GetMapping("/{codaul}")
    public AulaEntity buscarPorId(@PathVariable("codaul") Integer codaul) {
        return service.buscarPorId(codaul);
    }
}
