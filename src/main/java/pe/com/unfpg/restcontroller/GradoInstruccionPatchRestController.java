package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.GradoInstruccionEntity;
import pe.com.unfpg.service.GradoInstruccionService;

@RestController
@RequestMapping("/api/gradoinstruccion")
public class GradoInstruccionPatchRestController {
    private final GradoInstruccionService service;

    public GradoInstruccionPatchRestController(GradoInstruccionService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codgrai}", "/{codgrai}/habilitar"})
    public ResponseEntity<GradoInstruccionEntity> habilitar(@PathVariable("codgrai") Integer codgrai) {
        return ResponseEntity.ok(service.habilitar(codgrai));
    }
}
