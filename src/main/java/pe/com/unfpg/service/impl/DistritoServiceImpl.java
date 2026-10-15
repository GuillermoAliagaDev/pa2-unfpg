package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.DistritoEntity;
import pe.com.unfpg.repository.DistritoRepository;
import pe.com.unfpg.service.DistritoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class DistritoServiceImpl implements DistritoService {
    private final DistritoRepository repository;

    public DistritoServiceImpl(DistritoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DistritoEntity> listar() {
        return repository.findAll(Sort.by("coddis"));
    }

    @Override
    public DistritoEntity buscarPorId(Integer coddis) {
        if (coddis == null || coddis <= 0) throw ConsultaGetException.idInvalido("coddis");
        return repository.findById(coddis)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("distrito"));
    }
}
