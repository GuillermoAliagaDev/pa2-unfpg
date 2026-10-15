package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.MatriculaLmsEntity;
import pe.com.unfpg.service.MatriculaLmsService;

@RestController
@RequestMapping("/api/matriculalms")
public class MatriculaLmsGetRestController {
    private final MatriculaLmsService service;

    public MatriculaLmsGetRestController(MatriculaLmsService service) {
        this.service = service;
    }

    @GetMapping
    public List<MatriculaLmsEntity> listar() { return service.listar(); }

    @GetMapping("/{nummatl}")
    public MatriculaLmsEntity buscarPorId(@PathVariable("nummatl") Integer nummatl) {
        return service.buscarPorId(nummatl);
    }
}
