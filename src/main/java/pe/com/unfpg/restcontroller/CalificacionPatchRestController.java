package pe.com.unfpg.restcontroller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calificacion")
public class CalificacionPatchRestController {

    @PatchMapping(value = {"/{codcal}", "/{codcal}/habilitar"})
    public ResponseEntity<Map<String, Object>> habilitar(@PathVariable("codcal") Integer codcal) {
        return ResponseEntity.badRequest().body(Map.of(
            "estado", 400,
            "mensaje", "La entidad Calificacion no admite la operacion de habilitar porque no maneja campo de estado."
        ));
    }
}
