package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CategoriaLibroEntity;
import pe.com.unfpg.service.CategoriaLibroService;

@RestController
@RequestMapping("/api/categorialibro")
public class CategoriaLibroPutRestController {
    private final CategoriaLibroService service;

    public CategoriaLibroPutRestController(CategoriaLibroService service) {
        this.service = service;
    }

    @PutMapping("/{codcatl}")
    public ResponseEntity<CategoriaLibroEntity> actualizar(
            @PathVariable("codcatl") Integer codcatl,
            @RequestBody CategoriaLibroEntity datos) {
        return ResponseEntity.ok(service.actualizar(codcatl, datos));
    }
}
