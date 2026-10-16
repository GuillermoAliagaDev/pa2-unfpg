package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.GradoInstruccionEntity;
import pe.com.unfpg.service.GradoInstruccionService;

@RestController
@RequestMapping("/api/gradoinstruccion")
public class GradoInstruccionDeleteRestController {
    private final GradoInstruccionService service;

    public GradoInstruccionDeleteRestController(GradoInstruccionService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codgrai}", "/{codgrai}/deshabilitar"})
    public ResponseEntity<GradoInstruccionEntity> deshabilitar(@PathVariable("codgrai") Integer codgrai) {
        return ResponseEntity.ok(service.deshabilitar(codgrai));
    }
}
