package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.OrdenPagoEntity;
import pe.com.unfpg.service.OrdenPagoService;

@RestController
@RequestMapping("/api/ordenpago")
public class OrdenPagoGetRestController {
    private final OrdenPagoService service;

    public OrdenPagoGetRestController(OrdenPagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrdenPagoEntity> listar() { return service.listar(); }

    @GetMapping("/{codordpag}")
    public OrdenPagoEntity buscarPorId(@PathVariable("codordpag") Integer codordpag) {
        return service.buscarPorId(codordpag);
    }
}
