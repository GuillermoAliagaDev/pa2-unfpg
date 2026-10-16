package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.ProgramaEntity;
import pe.com.unfpg.service.ProgramaService;

@RestController
@RequestMapping("/api/programa")
public class ProgramaPutRestController {
    private final ProgramaService service;
    public ProgramaPutRestController(ProgramaService service) { this.service = service; }

    @PutMapping("/{codprog}")
    public ResponseEntity<ProgramaEntity> actualizar(@PathVariable("codprog") Integer codprog, @RequestBody ProgramaEntity datos) {
        return ResponseEntity.ok(service.actualizar(codprog, datos));
    }
}
