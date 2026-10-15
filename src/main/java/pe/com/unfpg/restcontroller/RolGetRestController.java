package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.RolEntity;
import pe.com.unfpg.service.RolService;

@RestController
@RequestMapping("/api/rol")
public class RolGetRestController {
    private final RolService service;

    public RolGetRestController(RolService service) {
        this.service = service;
    }

    @GetMapping
    public List<RolEntity> listar() { return service.listar(); }

    @GetMapping("/{codrol}")
    public RolEntity buscarPorId(@PathVariable("codrol") Integer codrol) {
        return service.buscarPorId(codrol);
    }
}
