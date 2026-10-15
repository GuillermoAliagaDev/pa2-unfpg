package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.TrasladoEntity;
import pe.com.unfpg.repository.TrasladoRepository;
import pe.com.unfpg.service.TrasladoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class TrasladoServiceImpl implements TrasladoService {
    private final TrasladoRepository repository;

    public TrasladoServiceImpl(TrasladoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TrasladoEntity> listar() {
        return repository.findAll(Sort.by("codtra"));
    }

    @Override
    public TrasladoEntity buscarPorId(Integer codtra) {
        if (codtra == null || codtra <= 0) throw ConsultaGetException.idInvalido("codtra");
        return repository.findById(codtra)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("traslado"));
    }
}
