package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.FacultadEntity;
import pe.com.unfpg.service.FacultadService;

@RestController
@RequestMapping("/api/facultad")
public class FacultadGetRestController {
    private final FacultadService service;

    public FacultadGetRestController(FacultadService service) {
        this.service = service;
    }

    @GetMapping
    public List<FacultadEntity> listar() { return service.listar(); }

    @GetMapping("/{codfac}")
    public FacultadEntity buscarPorId(@PathVariable("codfac") Integer codfac) {
        return service.buscarPorId(codfac);
    }
}
