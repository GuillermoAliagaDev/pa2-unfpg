package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.CalificacionEntity;
import pe.com.unfpg.repository.CalificacionRepository;
import pe.com.unfpg.service.CalificacionService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class CalificacionServiceImpl implements CalificacionService {
    private final CalificacionRepository repository;

    public CalificacionServiceImpl(CalificacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CalificacionEntity> listar() {
        return repository.findAll(Sort.by("codcal"));
    }

    @Override
    public CalificacionEntity buscarPorId(Integer codcal) {
        if (codcal == null || codcal <= 0) throw ConsultaGetException.idInvalido("codcal");
        return repository.findById(codcal)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("calificacion"));
    }
}
