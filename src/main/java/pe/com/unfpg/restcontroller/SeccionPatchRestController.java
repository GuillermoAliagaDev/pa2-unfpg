package pe.com.unfpg.restcontroller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seccion")
public class SeccionPatchRestController {

    @PatchMapping(value = {"/{codsec}", "/{codsec}/habilitar"})
    public ResponseEntity<Map<String, Object>> habilitar(@PathVariable("codsec") Integer codsec) {
        return ResponseEntity.badRequest().body(Map.of(
            "estado", 400,
            "mensaje", "La entidad Seccion no admite la operacion de habilitar porque no maneja campo de estado."
        ));
    }
}
