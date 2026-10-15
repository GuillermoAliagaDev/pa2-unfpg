package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CursoLmsEntity;
import pe.com.unfpg.service.CursoLmsService;

@RestController
@RequestMapping("/api/cursolms")
public class CursoLmsGetRestController {
    private final CursoLmsService service;

    public CursoLmsGetRestController(CursoLmsService service) {
        this.service = service;
    }

    @GetMapping
    public List<CursoLmsEntity> listar() { return service.listar(); }

    @GetMapping("/{codcurl}")
    public CursoLmsEntity buscarPorId(@PathVariable("codcurl") Integer codcurl) {
        return service.buscarPorId(codcurl);
    }
}
