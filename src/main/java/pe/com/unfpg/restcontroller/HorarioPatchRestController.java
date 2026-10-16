package pe.com.unfpg.restcontroller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/horario")
public class HorarioPatchRestController {

    @PatchMapping(value = {"/{codhor}", "/{codhor}/habilitar"})
    public ResponseEntity<Map<String, Object>> habilitar(@PathVariable("codhor") Integer codhor) {
        return ResponseEntity.badRequest().body(Map.of(
            "estado", 400,
            "mensaje", "La entidad Horario no admite la operacion de habilitar porque no maneja campo de estado."
        ));
    }
}
