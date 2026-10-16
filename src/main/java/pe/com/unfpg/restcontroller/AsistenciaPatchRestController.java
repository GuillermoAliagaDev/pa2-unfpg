package pe.com.unfpg.restcontroller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaPatchRestController {

    @PatchMapping(value = {"/{codasis}", "/{codasis}/habilitar"})
    public ResponseEntity<Map<String, Object>> habilitar(@PathVariable("codasis") Integer codasis) {
        return ResponseEntity.badRequest().body(Map.of(
            "estado", 400,
            "mensaje", "La entidad Asistencia no admite la operacion de habilitar porque no maneja campo de estado."
        ));
    }
}
