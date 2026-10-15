package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PlanEstudioEntity;
import pe.com.unfpg.service.PlanEstudioService;

@RestController
@RequestMapping("/api/planestudio")
public class PlanEstudioGetRestController {
    private final PlanEstudioService service;

    public PlanEstudioGetRestController(PlanEstudioService service) {
        this.service = service;
    }

    @GetMapping
    public List<PlanEstudioEntity> listar() { return service.listar(); }

    @GetMapping("/{codpla}")
    public PlanEstudioEntity buscarPorId(@PathVariable("codpla") Integer codpla) {
        return service.buscarPorId(codpla);
    }
}
