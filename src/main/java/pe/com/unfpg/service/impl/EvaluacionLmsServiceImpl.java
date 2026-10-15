package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.EvaluacionLmsEntity;
import pe.com.unfpg.repository.EvaluacionLmsRepository;
import pe.com.unfpg.service.EvaluacionLmsService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EvaluacionLmsServiceImpl implements EvaluacionLmsService {
    private final EvaluacionLmsRepository repository;

    public EvaluacionLmsServiceImpl(EvaluacionLmsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EvaluacionLmsEntity> listar() {
        return repository.findAll(Sort.by("codeval"));
    }

    @Override
    public EvaluacionLmsEntity buscarPorId(Integer codeval) {
        if (codeval == null || codeval <= 0) throw ConsultaGetException.idInvalido("codeval");
        return repository.findById(codeval)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("evaluacionlms"));
    }
}
