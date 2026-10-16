package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EjemplarLibroEntity;
import pe.com.unfpg.service.EjemplarLibroService;

@RestController
@RequestMapping("/api/ejemplarlibro")
public class EjemplarLibroDeleteRestController {
    private final EjemplarLibroService service;

    public EjemplarLibroDeleteRestController(EjemplarLibroService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codeje}", "/{codeje}/deshabilitar"})
    public ResponseEntity<EjemplarLibroEntity> deshabilitar(@PathVariable("codeje") Integer codeje) {
        return ResponseEntity.ok(service.deshabilitar(codeje));
    }
}
