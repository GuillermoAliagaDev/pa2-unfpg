package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.ProgramaEntity;
import pe.com.unfpg.service.ProgramaService;

@RestController
@RequestMapping("/api/programa")
public class ProgramaPatchRestController {
    private final ProgramaService service;

    public ProgramaPatchRestController(ProgramaService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codprog}", "/{codprog}/habilitar"})
    public ResponseEntity<ProgramaEntity> habilitar(@PathVariable("codprog") Integer codprog) {
        return ResponseEntity.ok(service.habilitar(codprog));
    }
}
