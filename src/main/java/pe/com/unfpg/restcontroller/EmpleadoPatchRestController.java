package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EmpleadoEntity;
import pe.com.unfpg.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoPatchRestController {
    private final EmpleadoService service;

    public EmpleadoPatchRestController(EmpleadoService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codemp}", "/{codemp}/habilitar"})
    public ResponseEntity<EmpleadoEntity> habilitar(@PathVariable("codemp") Integer codemp) {
        return ResponseEntity.ok(service.habilitar(codemp));
    }
}
