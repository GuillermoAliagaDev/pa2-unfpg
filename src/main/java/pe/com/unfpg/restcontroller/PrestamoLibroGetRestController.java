package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PrestamoLibroEntity;
import pe.com.unfpg.service.PrestamoLibroService;

@RestController
@RequestMapping("/api/prestamolibro")
public class PrestamoLibroGetRestController {
    private final PrestamoLibroService service;

    public PrestamoLibroGetRestController(PrestamoLibroService service) {
        this.service = service;
    }

    @GetMapping
    public List<PrestamoLibroEntity> listar() { return service.listar(); }

    @GetMapping("/{numpre}")
    public PrestamoLibroEntity buscarPorId(@PathVariable("numpre") Integer numpre) {
        return service.buscarPorId(numpre);
    }
}
