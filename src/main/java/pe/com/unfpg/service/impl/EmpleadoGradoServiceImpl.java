package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.EmpleadoGradoEntity;
import pe.com.unfpg.entity.EmpleadoGradoId;
import pe.com.unfpg.repository.EmpleadoGradoRepository;
import pe.com.unfpg.service.EmpleadoGradoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EmpleadoGradoServiceImpl implements EmpleadoGradoService {
    private final EmpleadoGradoRepository repository;

    public EmpleadoGradoServiceImpl(EmpleadoGradoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmpleadoGradoEntity> listar() {
        return repository.findAll(Sort.by("codemp", "codgrai"));
    }

    @Override
    public EmpleadoGradoEntity buscarPorId(Integer codemp, Integer codgrai) {
        if (codemp == null || codemp <= 0) throw ConsultaGetException.idInvalido("codemp");
        if (codgrai == null || codgrai <= 0) throw ConsultaGetException.idInvalido("codgrai");
        return repository.findById(new EmpleadoGradoId(codemp, codgrai))
            .orElseThrow(() -> ConsultaGetException.noEncontrado("empleadogrado"));
    }
}
