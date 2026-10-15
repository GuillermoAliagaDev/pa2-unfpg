package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PeriodoAcademicoEntity;
import pe.com.unfpg.service.PeriodoAcademicoService;

@RestController
@RequestMapping("/api/periodoacademico")
public class PeriodoAcademicoGetRestController {
    private final PeriodoAcademicoService service;

    public PeriodoAcademicoGetRestController(PeriodoAcademicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PeriodoAcademicoEntity> listar() { return service.listar(); }

    @GetMapping("/{codper}")
    public PeriodoAcademicoEntity buscarPorId(@PathVariable("codper") Integer codper) {
        return service.buscarPorId(codper);
    }
}
