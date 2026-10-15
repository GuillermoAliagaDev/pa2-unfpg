package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.RolLmsEntity;
import pe.com.unfpg.service.RolLmsService;

@RestController
@RequestMapping("/api/rollms")
public class RolLmsGetRestController {
    private final RolLmsService service;

    public RolLmsGetRestController(RolLmsService service) {
        this.service = service;
    }

    @GetMapping
    public List<RolLmsEntity> listar() { return service.listar(); }

    @GetMapping("/{codroll}")
    public RolLmsEntity buscarPorId(@PathVariable("codroll") Integer codroll) {
        return service.buscarPorId(codroll);
    }
}
