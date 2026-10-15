package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.AsistenciaEntity;
import pe.com.unfpg.service.AsistenciaService;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaGetRestController {
    private final AsistenciaService service;

    public AsistenciaGetRestController(AsistenciaService service) {
        this.service = service;
    }

    @GetMapping
    public List<AsistenciaEntity> listar() { return service.listar(); }

    @GetMapping("/{codasis}")
    public AsistenciaEntity buscarPorId(@PathVariable("codasis") Integer codasis) {
        return service.buscarPorId(codasis);
    }
}
