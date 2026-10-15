package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.UbicacionEntity;
import pe.com.unfpg.service.UbicacionService;

@RestController
@RequestMapping("/api/ubicacion")
public class UbicacionGetRestController {
    private final UbicacionService service;

    public UbicacionGetRestController(UbicacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<UbicacionEntity> listar() { return service.listar(); }

    @GetMapping("/{codubi}")
    public UbicacionEntity buscarPorId(@PathVariable("codubi") Integer codubi) {
        return service.buscarPorId(codubi);
    }
}
