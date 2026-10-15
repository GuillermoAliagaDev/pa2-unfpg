package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.ConceptoPagoEntity;
import pe.com.unfpg.service.ConceptoPagoService;

@RestController
@RequestMapping("/api/conceptopago")
public class ConceptoPagoGetRestController {
    private final ConceptoPagoService service;

    public ConceptoPagoGetRestController(ConceptoPagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ConceptoPagoEntity> listar() { return service.listar(); }

    @GetMapping("/{codconp}")
    public ConceptoPagoEntity buscarPorId(@PathVariable("codconp") Integer codconp) {
        return service.buscarPorId(codconp);
    }
}
