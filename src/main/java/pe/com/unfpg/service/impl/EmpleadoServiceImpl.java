package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.EmpleadoEntity;
import pe.com.unfpg.repository.EmpleadoRepository;
import pe.com.unfpg.service.EmpleadoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EmpleadoServiceImpl implements EmpleadoService {
    private final EmpleadoRepository repository;

    public EmpleadoServiceImpl(EmpleadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmpleadoEntity> listar() {
        return repository.findAll(Sort.by("codemp"));
    }

    @Override
    public EmpleadoEntity buscarPorId(Integer codemp) {
        if (codemp == null || codemp <= 0) throw ConsultaGetException.idInvalido("codemp");
        return repository.findById(codemp)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("empleado"));
    }
}
