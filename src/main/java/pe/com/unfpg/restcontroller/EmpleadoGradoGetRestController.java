package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.EmpleadoGradoEntity;
import pe.com.unfpg.service.EmpleadoGradoService;

@RestController
@RequestMapping("/api/empleadogrado")
public class EmpleadoGradoGetRestController {
    private final EmpleadoGradoService service;

    public EmpleadoGradoGetRestController(EmpleadoGradoService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmpleadoGradoEntity> listar() { return service.listar(); }

    @GetMapping("/{codemp}/{codgrai}")
    public EmpleadoGradoEntity buscarPorId(@PathVariable("codemp") Integer codemp, @PathVariable("codgrai") Integer codgrai) {
        return service.buscarPorId(codemp, codgrai);
    }
}
