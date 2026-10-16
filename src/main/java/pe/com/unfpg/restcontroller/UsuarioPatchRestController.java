package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.UsuarioEntity;
import pe.com.unfpg.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioPatchRestController {
    private final UsuarioService service;

    public UsuarioPatchRestController(UsuarioService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codusu}", "/{codusu}/habilitar"})
    public ResponseEntity<UsuarioEntity> habilitar(@PathVariable("codusu") Integer codusu) {
        return ResponseEntity.ok(service.habilitar(codusu));
    }
}
