package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EvaluacionLmsEntity;
import pe.com.unfpg.service.EvaluacionLmsService;

@RestController
@RequestMapping("/api/evaluacionlms")
public class EvaluacionLmsGetRestController {
    private final EvaluacionLmsService service;

    public EvaluacionLmsGetRestController(EvaluacionLmsService service) {
        this.service = service;
    }

    @GetMapping
    public List<EvaluacionLmsEntity> listar() { return service.listar(); }

    @GetMapping("/{codeval}")
    public EvaluacionLmsEntity buscarPorId(@PathVariable("codeval") Integer codeval) {
        return service.buscarPorId(codeval);
    }
}
