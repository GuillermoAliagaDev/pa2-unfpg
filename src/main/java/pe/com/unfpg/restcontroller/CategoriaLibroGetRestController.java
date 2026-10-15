package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CategoriaLibroEntity;
import pe.com.unfpg.service.CategoriaLibroService;

@RestController
@RequestMapping("/api/categorialibro")
public class CategoriaLibroGetRestController {
    private final CategoriaLibroService service;

    public CategoriaLibroGetRestController(CategoriaLibroService service) {
        this.service = service;
    }

    @GetMapping
    public List<CategoriaLibroEntity> listar() { return service.listar(); }

    @GetMapping("/{codcatl}")
    public CategoriaLibroEntity buscarPorId(@PathVariable("codcatl") Integer codcatl) {
        return service.buscarPorId(codcatl);
    }
}
