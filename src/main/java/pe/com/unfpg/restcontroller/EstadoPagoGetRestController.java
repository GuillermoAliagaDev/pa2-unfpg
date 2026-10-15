package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EstadoPagoEntity;
import pe.com.unfpg.service.EstadoPagoService;

@RestController
@RequestMapping("/api/estadopago")
public class EstadoPagoGetRestController {
    private final EstadoPagoService service;

    public EstadoPagoGetRestController(EstadoPagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<EstadoPagoEntity> listar() { return service.listar(); }

    @GetMapping("/{codestp}")
    public EstadoPagoEntity buscarPorId(@PathVariable("codestp") Integer codestp) {
        return service.buscarPorId(codestp);
    }
}
