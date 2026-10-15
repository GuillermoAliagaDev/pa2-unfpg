package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.SexoEntity;
import pe.com.unfpg.repository.SexoRepository;
import pe.com.unfpg.service.SexoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class SexoServiceImpl implements SexoService {
    private final SexoRepository repository;

    public SexoServiceImpl(SexoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SexoEntity> listar() {
        return repository.findAll(Sort.by("codsex"));
    }

    @Override
    public SexoEntity buscarPorId(Integer codsex) {
        if (codsex == null || codsex <= 0) throw ConsultaGetException.idInvalido("codsex");
        return repository.findById(codsex)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("sexo"));
    }
}
