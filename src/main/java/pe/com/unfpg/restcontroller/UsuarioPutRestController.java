package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.UsuarioEntity;
import pe.com.unfpg.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioPutRestController {
    private final UsuarioService service;
    public UsuarioPutRestController(UsuarioService service) { this.service = service; }

    @PutMapping("/{codusu}")
    public ResponseEntity<UsuarioEntity> actualizar(@PathVariable("codusu") Integer codusu, @RequestBody UsuarioEntity datos) {
        return ResponseEntity.ok(service.actualizar(codusu, datos));
    }
}
