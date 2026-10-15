package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.EstadoMatriculaEntity;
import pe.com.unfpg.repository.EstadoMatriculaRepository;
import pe.com.unfpg.service.EstadoMatriculaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EstadoMatriculaServiceImpl implements EstadoMatriculaService {
    private final EstadoMatriculaRepository repository;

    public EstadoMatriculaServiceImpl(EstadoMatriculaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EstadoMatriculaEntity> listar() {
        return repository.findAll(Sort.by("codestm"));
    }

    @Override
    public EstadoMatriculaEntity buscarPorId(Integer codestm) {
        if (codestm == null || codestm <= 0) throw ConsultaGetException.idInvalido("codestm");
        return repository.findById(codestm)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("estadomatricula"));
    }
}
