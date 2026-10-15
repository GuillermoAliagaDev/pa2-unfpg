package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EjemplarLibroEntity;
import pe.com.unfpg.service.EjemplarLibroService;

@RestController
@RequestMapping("/api/ejemplarlibro")
public class EjemplarLibroGetRestController {
    private final EjemplarLibroService service;

    public EjemplarLibroGetRestController(EjemplarLibroService service) {
        this.service = service;
    }

    @GetMapping
    public List<EjemplarLibroEntity> listar() { return service.listar(); }

    @GetMapping("/{codeje}")
    public EjemplarLibroEntity buscarPorId(@PathVariable("codeje") Integer codeje) {
        return service.buscarPorId(codeje);
    }
}
