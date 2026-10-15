package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.CargoEntity;
import pe.com.unfpg.service.CargoService;

@RestController
@RequestMapping("/api/cargo")
public class CargoGetRestController {
    private final CargoService service;

    public CargoGetRestController(CargoService service) {
        this.service = service;
    }

    @GetMapping
    public List<CargoEntity> listar() { return service.listar(); }

    @GetMapping("/{codcar}")
    public CargoEntity buscarPorId(@PathVariable("codcar") Integer codcar) {
        return service.buscarPorId(codcar);
    }
}
