package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CategoriaLibroEntity;
import pe.com.unfpg.service.CategoriaLibroService;

@RestController
@RequestMapping("/api/categorialibro")
public class CategoriaLibroPatchRestController {
    private final CategoriaLibroService service;

    public CategoriaLibroPatchRestController(CategoriaLibroService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codcatl}", "/{codcatl}/habilitar"})
    public ResponseEntity<CategoriaLibroEntity> habilitar(@PathVariable("codcatl") Integer codcatl) {
        return ResponseEntity.ok(service.habilitar(codcatl));
    }
}
