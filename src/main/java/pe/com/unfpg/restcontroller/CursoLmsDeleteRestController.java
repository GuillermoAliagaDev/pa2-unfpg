package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CursoLmsEntity;
import pe.com.unfpg.service.CursoLmsService;

@RestController
@RequestMapping("/api/cursolms")
public class CursoLmsDeleteRestController {
    private final CursoLmsService service;

    public CursoLmsDeleteRestController(CursoLmsService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codcurl}", "/{codcurl}/deshabilitar"})
    public ResponseEntity<CursoLmsEntity> deshabilitar(@PathVariable("codcurl") Integer codcurl) {
        return ResponseEntity.ok(service.deshabilitar(codcurl));
    }
}
