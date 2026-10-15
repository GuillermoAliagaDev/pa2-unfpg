package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.GradoInstruccionEntity;
import pe.com.unfpg.service.GradoInstruccionService;

@RestController
@RequestMapping("/api/gradoinstruccion")
public class GradoInstruccionGetRestController {
    private final GradoInstruccionService service;

    public GradoInstruccionGetRestController(GradoInstruccionService service) {
        this.service = service;
    }

    @GetMapping
    public List<GradoInstruccionEntity> listar() { return service.listar(); }

    @GetMapping("/{codgrai}")
    public GradoInstruccionEntity buscarPorId(@PathVariable("codgrai") Integer codgrai) {
        return service.buscarPorId(codgrai);
    }
}
