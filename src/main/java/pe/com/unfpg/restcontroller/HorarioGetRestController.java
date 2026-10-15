package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.HorarioEntity;
import pe.com.unfpg.service.HorarioService;

@RestController
@RequestMapping("/api/horario")
public class HorarioGetRestController {
    private final HorarioService service;

    public HorarioGetRestController(HorarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<HorarioEntity> listar() { return service.listar(); }

    @GetMapping("/{codhor}")
    public HorarioEntity buscarPorId(@PathVariable("codhor") Integer codhor) {
        return service.buscarPorId(codhor);
    }
}
