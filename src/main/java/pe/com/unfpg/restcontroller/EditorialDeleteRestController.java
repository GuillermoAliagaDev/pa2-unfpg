package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EditorialEntity;
import pe.com.unfpg.service.EditorialService;

@RestController
@RequestMapping("/api/editorial")
public class EditorialDeleteRestController {
    private final EditorialService service;

    public EditorialDeleteRestController(EditorialService service) {
        this.service = service;
    }

    @DeleteMapping(value = {"/{codedi}", "/{codedi}/deshabilitar"})
    public ResponseEntity<EditorialEntity> deshabilitar(@PathVariable("codedi") Integer codedi) {
        return ResponseEntity.ok(service.deshabilitar(codedi));
    }
}
