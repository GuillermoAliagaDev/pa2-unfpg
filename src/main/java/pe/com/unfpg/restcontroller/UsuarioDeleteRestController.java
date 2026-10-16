package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.UsuarioEntity;
import pe.com.unfpg.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioDeleteRestController {
    private final UsuarioService service;

    public UsuarioDeleteRestController(UsuarioService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codusu}", "/{codusu}/deshabilitar"})
    public ResponseEntity<UsuarioEntity> deshabilitar(@PathVariable("codusu") Integer codusu) {
        return ResponseEntity.ok(service.deshabilitar(codusu));
    }
}
