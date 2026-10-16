package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CategoriaLibroEntity;
import pe.com.unfpg.service.CategoriaLibroService;

@RestController
@RequestMapping("/api/categorialibro")
public class CategoriaLibroDeleteRestController {
    private final CategoriaLibroService service;

    public CategoriaLibroDeleteRestController(CategoriaLibroService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codcatl}", "/{codcatl}/deshabilitar"})
    public ResponseEntity<CategoriaLibroEntity> deshabilitar(@PathVariable("codcatl") Integer codcatl) {
        return ResponseEntity.ok(service.deshabilitar(codcatl));
    }
}
