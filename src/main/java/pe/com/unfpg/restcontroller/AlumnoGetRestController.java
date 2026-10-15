package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.AlumnoEntity;
import pe.com.unfpg.service.AlumnoService;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoGetRestController {
    private final AlumnoService service;

    public AlumnoGetRestController(AlumnoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AlumnoEntity> listar() { return service.listar(); }

    @GetMapping("/{codalu}")
    public AlumnoEntity buscarPorId(@PathVariable("codalu") Integer codalu) {
        return service.buscarPorId(codalu);
    }
}
