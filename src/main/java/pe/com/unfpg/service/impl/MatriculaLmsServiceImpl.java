package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.MatriculaLmsEntity;
import pe.com.unfpg.repository.MatriculaLmsRepository;
import pe.com.unfpg.service.MatriculaLmsService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class MatriculaLmsServiceImpl implements MatriculaLmsService {
    private final MatriculaLmsRepository repository;

    public MatriculaLmsServiceImpl(MatriculaLmsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MatriculaLmsEntity> listar() {
        return repository.findAll(Sort.by("nummatl"));
    }

    @Override
    public MatriculaLmsEntity buscarPorId(Integer nummatl) {
        if (nummatl == null || nummatl <= 0) throw ConsultaGetException.idInvalido("nummatl");
        return repository.findById(nummatl)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("matriculalms"));
    }
}
