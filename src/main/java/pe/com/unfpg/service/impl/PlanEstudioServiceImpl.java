package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.PlanEstudioEntity;
import pe.com.unfpg.repository.PlanEstudioRepository;
import pe.com.unfpg.service.PlanEstudioService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class PlanEstudioServiceImpl implements PlanEstudioService {
    private final PlanEstudioRepository repository;

    public PlanEstudioServiceImpl(PlanEstudioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PlanEstudioEntity> listar() {
        return repository.findAll(Sort.by("codpla"));
    }

    @Override
    public PlanEstudioEntity buscarPorId(Integer codpla) {
        if (codpla == null || codpla <= 0) throw ConsultaGetException.idInvalido("codpla");
        return repository.findById(codpla)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("planestudio"));
    }
}
