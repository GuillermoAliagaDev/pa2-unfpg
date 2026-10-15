package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EditorialEntity;
import pe.com.unfpg.service.EditorialService;

@RestController
@RequestMapping("/api/editorial")
public class EditorialGetRestController {
    private final EditorialService service;

    public EditorialGetRestController(EditorialService service) {
        this.service = service;
    }

    @GetMapping
    public List<EditorialEntity> listar() { return service.listar(); }

    @GetMapping("/{codedi}")
    public EditorialEntity buscarPorId(@PathVariable("codedi") Integer codedi) {
        return service.buscarPorId(codedi);
    }
}
