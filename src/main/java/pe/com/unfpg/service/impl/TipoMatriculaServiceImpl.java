package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.TipoMatriculaEntity;
import pe.com.unfpg.repository.TipoMatriculaRepository;
import pe.com.unfpg.service.TipoMatriculaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class TipoMatriculaServiceImpl implements TipoMatriculaService {
    private final TipoMatriculaRepository repository;

    public TipoMatriculaServiceImpl(TipoMatriculaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TipoMatriculaEntity> listar() {
        return repository.findAll(Sort.by("codtipm"));
    }

    @Override
    public TipoMatriculaEntity buscarPorId(Integer codtipm) {
        if (codtipm == null || codtipm <= 0) throw ConsultaGetException.idInvalido("codtipm");
        return repository.findById(codtipm)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("tipomatricula"));
    }
}
