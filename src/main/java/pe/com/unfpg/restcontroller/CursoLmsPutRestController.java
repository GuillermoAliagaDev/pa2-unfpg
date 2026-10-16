package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CursoLmsEntity;
import pe.com.unfpg.service.CursoLmsService;

@RestController
@RequestMapping("/api/cursolms")
public class CursoLmsPutRestController {
    private final CursoLmsService service;
    public CursoLmsPutRestController(CursoLmsService service) { this.service = service; }

    @PutMapping("/{codcurl}")
    public ResponseEntity<CursoLmsEntity> actualizar(@PathVariable("codcurl") Integer codcurl, @RequestBody CursoLmsEntity datos) {
        return ResponseEntity.ok(service.actualizar(codcurl, datos));
    }
}
