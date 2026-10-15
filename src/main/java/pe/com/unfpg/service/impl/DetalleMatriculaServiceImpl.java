package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.DetalleMatriculaEntity;
import pe.com.unfpg.repository.DetalleMatriculaRepository;
import pe.com.unfpg.service.DetalleMatriculaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class DetalleMatriculaServiceImpl implements DetalleMatriculaService {
    private final DetalleMatriculaRepository repository;

    public DetalleMatriculaServiceImpl(DetalleMatriculaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DetalleMatriculaEntity> listar() {
        return repository.findAll(Sort.by("coddet"));
    }

    @Override
    public DetalleMatriculaEntity buscarPorId(Integer coddet) {
        if (coddet == null || coddet <= 0) throw ConsultaGetException.idInvalido("coddet");
        return repository.findById(coddet)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("detallematricula"));
    }
}
