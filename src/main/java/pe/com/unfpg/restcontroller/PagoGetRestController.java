package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.PagoEntity;
import pe.com.unfpg.service.PagoService;

@RestController
@RequestMapping("/api/pago")
public class PagoGetRestController {
    private final PagoService service;

    public PagoGetRestController(PagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PagoEntity> listar() { return service.listar(); }

    @GetMapping("/{codpag}")
    public PagoEntity buscarPorId(@PathVariable("codpag") Integer codpag) {
        return service.buscarPorId(codpag);
    }
}
