package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CursoEntity;
import pe.com.unfpg.service.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoGetRestController {
    private final CursoService service;

    public CursoGetRestController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public List<CursoEntity> listar() { return service.listar(); }

    @GetMapping("/{codcur}")
    public CursoEntity buscarPorId(@PathVariable("codcur") Integer codcur) {
        return service.buscarPorId(codcur);
    }
}
