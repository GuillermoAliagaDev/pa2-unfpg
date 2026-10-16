package pe.com.unfpg.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EditorialEntity;
import pe.com.unfpg.service.EditorialService;

@RestController
@RequestMapping("/api/editorial")
public class EditorialPatchRestController {
    private final EditorialService service;

    public EditorialPatchRestController(EditorialService service) {
        this.service = service;
    }

    @PatchMapping(value = {"/{codedi}", "/{codedi}/habilitar"})
    public ResponseEntity<EditorialEntity> habilitar(@PathVariable("codedi") Integer codedi) {
        return ResponseEntity.ok(service.habilitar(codedi));
    }
}
