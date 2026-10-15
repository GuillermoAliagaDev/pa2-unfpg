package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DocenteGradoEntity;
import pe.com.unfpg.service.DocenteGradoService;

@RestController
@RequestMapping("/api/docentegrado")
public class DocenteGradoGetRestController {
    private final DocenteGradoService service;

    public DocenteGradoGetRestController(DocenteGradoService service) {
        this.service = service;
    }

    @GetMapping
    public List<DocenteGradoEntity> listar() { return service.listar(); }

    @GetMapping("/{coddoc}/{codgrai}")
    public DocenteGradoEntity buscarPorId(@PathVariable("coddoc") Integer coddoc, @PathVariable("codgrai") Integer codgrai) {
        return service.buscarPorId(coddoc, codgrai);
    }
}
