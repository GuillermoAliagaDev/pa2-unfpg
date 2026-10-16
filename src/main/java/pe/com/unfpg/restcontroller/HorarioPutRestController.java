package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.HorarioEntity;
import pe.com.unfpg.service.HorarioService;

@RestController
@RequestMapping("/api/horario")
public class HorarioPutRestController {
    private final HorarioService service;
    public HorarioPutRestController(HorarioService service) { this.service = service; }

    @PutMapping("/{codhor}")
    public ResponseEntity<HorarioEntity> actualizar(@PathVariable("codhor") Integer codhor, @RequestBody HorarioEntity datos) {
        return ResponseEntity.ok(service.actualizar(codhor, datos));
    }
}
