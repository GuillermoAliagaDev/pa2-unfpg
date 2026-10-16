package pe.com.unfpg.restcontroller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/curso")
public class CursoPatchRestController {

    @PatchMapping(value = {"/{codcur}", "/{codcur}/habilitar"})
    public ResponseEntity<Map<String, Object>> habilitar(@PathVariable("codcur") Integer codcur) {
        return ResponseEntity.badRequest().body(Map.of(
            "estado", 400,
            "mensaje", "La entidad Curso no admite la operacion de habilitar porque no maneja campo de estado."
        ));
    }
}
