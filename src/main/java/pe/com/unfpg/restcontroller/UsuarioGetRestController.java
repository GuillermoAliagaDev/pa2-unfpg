package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.UsuarioEntity;
import pe.com.unfpg.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioGetRestController {
    private final UsuarioService service;

    public UsuarioGetRestController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioEntity> listar() { return service.listar(); }

    @GetMapping("/{codusu}")
    public UsuarioEntity buscarPorId(@PathVariable("codusu") Integer codusu) {
        return service.buscarPorId(codusu);
    }
}
