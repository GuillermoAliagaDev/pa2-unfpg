package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DiaSemanaEntity;
import pe.com.unfpg.service.DiaSemanaService;

@RestController
@RequestMapping("/api/diasemana")
public class DiaSemanaGetRestController {
    private final DiaSemanaService service;

    public DiaSemanaGetRestController(DiaSemanaService service) {
        this.service = service;
    }

    @GetMapping
    public List<DiaSemanaEntity> listar() { return service.listar(); }

    @GetMapping("/{coddias}")
    public DiaSemanaEntity buscarPorId(@PathVariable("coddias") Integer coddias) {
        return service.buscarPorId(coddias);
    }
}
