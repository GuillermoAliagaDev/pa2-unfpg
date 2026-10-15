package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DocenteEntity;
import pe.com.unfpg.service.DocenteService;

@RestController
@RequestMapping("/api/docente")
public class DocenteGetRestController {
    private final DocenteService service;

    public DocenteGetRestController(DocenteService service) {
        this.service = service;
    }

    @GetMapping
    public List<DocenteEntity> listar() { return service.listar(); }

    @GetMapping("/{coddoc}")
    public DocenteEntity buscarPorId(@PathVariable("coddoc") Integer coddoc) {
        return service.buscarPorId(coddoc);
    }
}
