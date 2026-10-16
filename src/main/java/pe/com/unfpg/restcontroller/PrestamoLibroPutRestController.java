package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PrestamoLibroEntity;
import pe.com.unfpg.service.PrestamoLibroService;

@RestController
@RequestMapping("/api/prestamolibro")
public class PrestamoLibroPutRestController {
    private final PrestamoLibroService service;
    public PrestamoLibroPutRestController(PrestamoLibroService service) { this.service = service; }

    @PutMapping("/{numpre}")
    public ResponseEntity<PrestamoLibroEntity> actualizar(@PathVariable("numpre") Integer numpre, @RequestBody PrestamoLibroEntity datos) {
        return ResponseEntity.ok(service.actualizar(numpre, datos));
    }
}
