package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EjemplarLibroEntity;
import pe.com.unfpg.service.EjemplarLibroService;

@RestController
@RequestMapping("/api/ejemplarlibro")
public class EjemplarLibroPatchRestController {
    private final EjemplarLibroService service;

    public EjemplarLibroPatchRestController(EjemplarLibroService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codeje}", "/{codeje}/habilitar"})
    public ResponseEntity<EjemplarLibroEntity> habilitar(@PathVariable("codeje") Integer codeje) {
        return ResponseEntity.ok(service.habilitar(codeje));
    }
}
