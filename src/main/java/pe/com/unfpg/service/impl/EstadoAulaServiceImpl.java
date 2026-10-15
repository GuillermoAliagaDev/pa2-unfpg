package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.EstadoAulaEntity;
import pe.com.unfpg.repository.EstadoAulaRepository;
import pe.com.unfpg.service.EstadoAulaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EstadoAulaServiceImpl implements EstadoAulaService {
    private final EstadoAulaRepository repository;

    public EstadoAulaServiceImpl(EstadoAulaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EstadoAulaEntity> listar() {
        return repository.findAll(Sort.by("codesta"));
    }

    @Override
    public EstadoAulaEntity buscarPorId(Integer codesta) {
        if (codesta == null || codesta <= 0) throw ConsultaGetException.idInvalido("codesta");
        return repository.findById(codesta)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("estadoaula"));
    }
}
