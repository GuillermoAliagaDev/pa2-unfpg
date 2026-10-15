package pe.com.unfpg.restcontroller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.entity.TipoDocumentoEntity;
import pe.com.unfpg.service.TipoDocumentoService;

@RestController
@RequestMapping("/api/tipodocumento")
public class TipoDocumentoGetRestController {
    private final TipoDocumentoService service;

    public TipoDocumentoGetRestController(TipoDocumentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoDocumentoEntity> listar() { return service.listar(); }

    @GetMapping("/{codtipd}")
    public TipoDocumentoEntity buscarPorId(@PathVariable("codtipd") Integer codtipd) {
        return service.buscarPorId(codtipd);
    }
}
