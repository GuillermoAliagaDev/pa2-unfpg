package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.UsuarioRolEntity;
import pe.com.unfpg.service.UsuarioRolService;

@RestController
@RequestMapping("/api/usuariorol")
public class UsuarioRolGetRestController {
    private final UsuarioRolService service;

    public UsuarioRolGetRestController(UsuarioRolService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioRolEntity> listar() { return service.listar(); }

    @GetMapping("/{codusu}/{codrol}")
    public UsuarioRolEntity buscarPorId(@PathVariable("codusu") Integer codusu, @PathVariable("codrol") Integer codrol) {
        return service.buscarPorId(codusu, codrol);
    }
}
