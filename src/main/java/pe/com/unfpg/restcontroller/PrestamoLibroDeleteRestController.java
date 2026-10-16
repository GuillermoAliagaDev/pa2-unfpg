package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PrestamoLibroEntity;
import pe.com.unfpg.service.PrestamoLibroService;

@RestController
@RequestMapping("/api/prestamolibro")
public class PrestamoLibroDeleteRestController {
    private final PrestamoLibroService service;

    public PrestamoLibroDeleteRestController(PrestamoLibroService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{numpre}", "/{numpre}/deshabilitar"})
    public ResponseEntity<PrestamoLibroEntity> deshabilitar(@PathVariable("numpre") Integer numpre) {
        return ResponseEntity.ok(service.deshabilitar(numpre));
    }
}
