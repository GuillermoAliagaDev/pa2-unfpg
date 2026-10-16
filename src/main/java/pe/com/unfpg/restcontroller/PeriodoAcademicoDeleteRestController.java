package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PeriodoAcademicoEntity;
import pe.com.unfpg.service.PeriodoAcademicoService;

@RestController
@RequestMapping("/api/periodoacademico")
public class PeriodoAcademicoDeleteRestController {
    private final PeriodoAcademicoService service;

    public PeriodoAcademicoDeleteRestController(PeriodoAcademicoService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codper}", "/{codper}/deshabilitar"})
    public ResponseEntity<PeriodoAcademicoEntity> deshabilitar(@PathVariable("codper") Integer codper) {
        return ResponseEntity.ok(service.deshabilitar(codper));
    }
}
