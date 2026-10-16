package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.ProgramaEntity;
import pe.com.unfpg.service.ProgramaService;

@RestController
@RequestMapping("/api/programa")
public class ProgramaDeleteRestController {
    private final ProgramaService service;

    public ProgramaDeleteRestController(ProgramaService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codprog}", "/{codprog}/deshabilitar"})
    public ResponseEntity<ProgramaEntity> deshabilitar(@PathVariable("codprog") Integer codprog) {
        return ResponseEntity.ok(service.deshabilitar(codprog));
    }
}
