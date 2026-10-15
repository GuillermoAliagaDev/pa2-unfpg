package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.PeriodoAcademicoEntity;
import pe.com.unfpg.repository.PeriodoAcademicoRepository;
import pe.com.unfpg.service.PeriodoAcademicoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class PeriodoAcademicoServiceImpl implements PeriodoAcademicoService {
    private final PeriodoAcademicoRepository repository;

    public PeriodoAcademicoServiceImpl(PeriodoAcademicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PeriodoAcademicoEntity> listar() {
        return repository.findAll(Sort.by("codper"));
    }

    @Override
    public PeriodoAcademicoEntity buscarPorId(Integer codper) {
        if (codper == null || codper <= 0) throw ConsultaGetException.idInvalido("codper");
        return repository.findById(codper)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("periodoacademico"));
    }
}
