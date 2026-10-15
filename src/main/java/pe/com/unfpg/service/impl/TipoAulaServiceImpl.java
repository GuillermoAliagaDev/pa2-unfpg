package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.TipoAulaEntity;
import pe.com.unfpg.repository.TipoAulaRepository;
import pe.com.unfpg.service.TipoAulaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class TipoAulaServiceImpl implements TipoAulaService {
    private final TipoAulaRepository repository;

    public TipoAulaServiceImpl(TipoAulaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TipoAulaEntity> listar() {
        return repository.findAll(Sort.by("codtipa"));
    }

    @Override
    public TipoAulaEntity buscarPorId(Integer codtipa) {
        if (codtipa == null || codtipa <= 0) throw ConsultaGetException.idInvalido("codtipa");
        return repository.findById(codtipa)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("tipoaula"));
    }
}
