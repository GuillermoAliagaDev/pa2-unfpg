package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DistritoEntity;
import pe.com.unfpg.service.DistritoService;

@RestController
@RequestMapping("/api/distrito")
public class DistritoGetRestController {
    private final DistritoService service;

    public DistritoGetRestController(DistritoService service) {
        this.service = service;
    }

    @GetMapping
    public List<DistritoEntity> listar() { return service.listar(); }

    @GetMapping("/{coddis}")
    public DistritoEntity buscarPorId(@PathVariable("coddis") Integer coddis) {
        return service.buscarPorId(coddis);
    }
}
