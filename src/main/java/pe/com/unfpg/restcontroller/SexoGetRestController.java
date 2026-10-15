package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.SexoEntity;
import pe.com.unfpg.service.SexoService;

@RestController
@RequestMapping("/api/sexo")
public class SexoGetRestController {
    private final SexoService service;

    public SexoGetRestController(SexoService service) {
        this.service = service;
    }

    @GetMapping
    public List<SexoEntity> listar() { return service.listar(); }

    @GetMapping("/{codsex}")
    public SexoEntity buscarPorId(@PathVariable("codsex") Integer codsex) {
        return service.buscarPorId(codsex);
    }
}
