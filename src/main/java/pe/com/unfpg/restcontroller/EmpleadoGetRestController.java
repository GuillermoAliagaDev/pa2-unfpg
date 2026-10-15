package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EmpleadoEntity;
import pe.com.unfpg.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoGetRestController {
    private final EmpleadoService service;

    public EmpleadoGetRestController(EmpleadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmpleadoEntity> listar() { return service.listar(); }

    @GetMapping("/{codemp}")
    public EmpleadoEntity buscarPorId(@PathVariable("codemp") Integer codemp) {
        return service.buscarPorId(codemp);
    }
}
