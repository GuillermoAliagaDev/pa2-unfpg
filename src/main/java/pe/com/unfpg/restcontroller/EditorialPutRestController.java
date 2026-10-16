package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EditorialEntity;
import pe.com.unfpg.service.EditorialService;

@RestController
@RequestMapping("/api/editorial")
public class EditorialPutRestController {
    private final EditorialService service;
    public EditorialPutRestController(EditorialService service) { this.service = service; }

    @PutMapping("/{codedi}")
    public ResponseEntity<EditorialEntity> actualizar(@PathVariable("codedi") Integer codedi, @RequestBody EditorialEntity datos) {
        return ResponseEntity.ok(service.actualizar(codedi, datos));
    }
}
