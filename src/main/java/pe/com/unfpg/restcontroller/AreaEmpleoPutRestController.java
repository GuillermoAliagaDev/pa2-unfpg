
package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.com.unfpg.entity.AreaEmpleoEntity;
import pe.com.unfpg.service.AreaEmpleoService;

@RestController
@RequestMapping("/api/areaempleo")
public class AreaEmpleoPutRestController {

    private final AreaEmpleoService service;

    public AreaEmpleoPutRestController(AreaEmpleoService service) {
        this.service = service;
    }

    @PutMapping("/{codare}")
    public ResponseEntity<AreaEmpleoEntity> actualizar(
            @PathVariable Integer codare,
            @RequestBody AreaEmpleoEntity datos) {

        AreaEmpleoEntity actualizado =
                service.actualizar(codare, datos);

        return ResponseEntity.ok(actualizado);
    }
}

