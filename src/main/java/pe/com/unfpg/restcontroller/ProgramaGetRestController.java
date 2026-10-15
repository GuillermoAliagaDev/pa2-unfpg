package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.ProgramaEntity;
import pe.com.unfpg.service.ProgramaService;

@RestController
@RequestMapping("/api/programa")
public class ProgramaGetRestController {
    private final ProgramaService service;

    public ProgramaGetRestController(ProgramaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProgramaEntity> listar() { return service.listar(); }

    @GetMapping("/{codprog}")
    public ProgramaEntity buscarPorId(@PathVariable("codprog") Integer codprog) {
        return service.buscarPorId(codprog);
    }
}
