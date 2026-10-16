package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PeriodoAcademicoEntity;
import pe.com.unfpg.service.PeriodoAcademicoService;

@RestController
@RequestMapping("/api/periodoacademico")
public class PeriodoAcademicoPatchRestController {
    private final PeriodoAcademicoService service;

    public PeriodoAcademicoPatchRestController(PeriodoAcademicoService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codper}", "/{codper}/habilitar"})
    public ResponseEntity<PeriodoAcademicoEntity> habilitar(@PathVariable("codper") Integer codper) {
        return ResponseEntity.ok(service.habilitar(codper));
    }
}
