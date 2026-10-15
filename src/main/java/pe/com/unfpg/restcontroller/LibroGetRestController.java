package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.LibroEntity;
import pe.com.unfpg.service.LibroService;

@RestController
@RequestMapping("/api/libro")
public class LibroGetRestController {
    private final LibroService service;

    public LibroGetRestController(LibroService service) {
        this.service = service;
    }

    @GetMapping
    public List<LibroEntity> listar() { return service.listar(); }

    @GetMapping("/{codlib}")
    public LibroEntity buscarPorId(@PathVariable("codlib") Integer codlib) {
        return service.buscarPorId(codlib);
    }
}
