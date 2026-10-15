package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.MatriculaEntity;
import pe.com.unfpg.service.MatriculaService;

@RestController
@RequestMapping("/api/matricula")
public class MatriculaGetRestController {
    private final MatriculaService service;

    public MatriculaGetRestController(MatriculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<MatriculaEntity> listar() { return service.listar(); }

    @GetMapping("/{nummat}")
    public MatriculaEntity buscarPorId(@PathVariable("nummat") Integer nummat) {
        return service.buscarPorId(nummat);
    }
}
