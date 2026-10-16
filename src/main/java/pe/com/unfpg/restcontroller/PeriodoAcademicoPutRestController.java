package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PeriodoAcademicoEntity;
import pe.com.unfpg.service.PeriodoAcademicoService;

@RestController
@RequestMapping("/api/periodoacademico")
public class PeriodoAcademicoPutRestController {
    private final PeriodoAcademicoService service;
    public PeriodoAcademicoPutRestController(PeriodoAcademicoService service) { this.service = service; }

    @PutMapping("/{codper}")
    public ResponseEntity<PeriodoAcademicoEntity> actualizar(@PathVariable("codper") Integer codper, @RequestBody PeriodoAcademicoEntity datos) {
        return ResponseEntity.ok(service.actualizar(codper, datos));
    }
}
