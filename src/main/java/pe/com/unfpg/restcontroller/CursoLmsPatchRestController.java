package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CursoLmsEntity;
import pe.com.unfpg.service.CursoLmsService;

@RestController
@RequestMapping("/api/cursolms")
public class CursoLmsPatchRestController {
    private final CursoLmsService service;

    public CursoLmsPatchRestController(CursoLmsService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codcurl}", "/{codcurl}/habilitar"})
    public ResponseEntity<CursoLmsEntity> habilitar(@PathVariable("codcurl") Integer codcurl) {
        return ResponseEntity.ok(service.habilitar(codcurl));
    }
}
