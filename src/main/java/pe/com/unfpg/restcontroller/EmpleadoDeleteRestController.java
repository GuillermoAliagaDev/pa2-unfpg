package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EmpleadoEntity;
import pe.com.unfpg.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoDeleteRestController {
    private final EmpleadoService service;

    public EmpleadoDeleteRestController(EmpleadoService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codemp}", "/{codemp}/deshabilitar"})
    public ResponseEntity<EmpleadoEntity> deshabilitar(@PathVariable("codemp") Integer codemp) {
        return ResponseEntity.ok(service.deshabilitar(codemp));
    }
}
