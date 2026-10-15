package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.DetalleMatriculaEntity;
import pe.com.unfpg.service.DetalleMatriculaService;

@RestController
@RequestMapping("/api/detallematricula")
public class DetalleMatriculaGetRestController {
    private final DetalleMatriculaService service;

    public DetalleMatriculaGetRestController(DetalleMatriculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<DetalleMatriculaEntity> listar() { return service.listar(); }

    @GetMapping("/{coddet}")
    public DetalleMatriculaEntity buscarPorId(@PathVariable("coddet") Integer coddet) {
        return service.buscarPorId(coddet);
    }
}
