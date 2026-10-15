package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.MetodoPagoEntity;
import pe.com.unfpg.service.MetodoPagoService;

@RestController
@RequestMapping("/api/metodopago")
public class MetodoPagoGetRestController {
    private final MetodoPagoService service;

    public MetodoPagoGetRestController(MetodoPagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<MetodoPagoEntity> listar() { return service.listar(); }

    @GetMapping("/{codmetp}")
    public MetodoPagoEntity buscarPorId(@PathVariable("codmetp") Integer codmetp) {
        return service.buscarPorId(codmetp);
    }
}
