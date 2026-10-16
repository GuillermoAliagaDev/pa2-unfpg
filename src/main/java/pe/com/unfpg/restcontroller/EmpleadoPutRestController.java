package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EmpleadoEntity;
import pe.com.unfpg.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoPutRestController {
    private final EmpleadoService service;
    public EmpleadoPutRestController(EmpleadoService service) { this.service = service; }

    @PutMapping("/{codemp}")
    public ResponseEntity<EmpleadoEntity> actualizar(@PathVariable("codemp") Integer codemp, @RequestBody EmpleadoEntity datos) {
        return ResponseEntity.ok(service.actualizar(codemp, datos));
    }
}
