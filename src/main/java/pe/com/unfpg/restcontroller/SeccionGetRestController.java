package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.SeccionEntity;
import pe.com.unfpg.service.SeccionService;

@RestController
@RequestMapping("/api/seccion")
public class SeccionGetRestController {
    private final SeccionService service;

    public SeccionGetRestController(SeccionService service) {
        this.service = service;
    }

    @GetMapping
    public List<SeccionEntity> listar() { return service.listar(); }

    @GetMapping("/{codsec}")
    public SeccionEntity buscarPorId(@PathVariable("codsec") Integer codsec) {
        return service.buscarPorId(codsec);
    }
}
