package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PrestamoLibroEntity;
import pe.com.unfpg.service.PrestamoLibroService;

@RestController
@RequestMapping("/api/prestamolibro")
public class PrestamoLibroPatchRestController {
    private final PrestamoLibroService service;

    public PrestamoLibroPatchRestController(PrestamoLibroService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{numpre}", "/{numpre}/habilitar"})
    public ResponseEntity<PrestamoLibroEntity> habilitar(@PathVariable("numpre") Integer numpre) {
        return ResponseEntity.ok(service.habilitar(numpre));
    }
}
