package pe.com.unfpg.restcontroller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aula")
public class AulaPatchRestController {

    @PatchMapping(value = {"/{codaul}", "/{codaul}/habilitar"})
    public ResponseEntity<Map<String, Object>> habilitar(@PathVariable("codaul") Integer codaul) {
        return ResponseEntity.badRequest().body(Map.of(
            "estado", 400,
            "mensaje", "La entidad Aula no admite la operacion de habilitar porque no maneja campo de estado."
        ));
    }
}
