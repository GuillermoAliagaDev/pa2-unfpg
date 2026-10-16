package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.service.HorarioService;

@RestController
@RequestMapping("/api/horario")
public class HorarioDeleteRestController {
    private final HorarioService service;

    public HorarioDeleteRestController(HorarioService service) {
        this.service = service;
    }

    @DeleteMapping("/{codhor}")
    public ResponseEntity<Void> eliminar(@PathVariable("codhor") Integer codhor) {
        service.eliminar(codhor);
        return ResponseEntity.noContent().build();
    }
}
