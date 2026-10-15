package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.MatriculaEntity;
import pe.com.unfpg.repository.MatriculaRepository;
import pe.com.unfpg.service.MatriculaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class MatriculaServiceImpl implements MatriculaService {
    private final MatriculaRepository repository;

    public MatriculaServiceImpl(MatriculaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MatriculaEntity> listar() {
        return repository.findAll(Sort.by("nummat"));
    }

    @Override
    public MatriculaEntity buscarPorId(Integer nummat) {
        if (nummat == null || nummat <= 0) throw ConsultaGetException.idInvalido("nummat");
        return repository.findById(nummat)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("matricula"));
    }
}
