package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.BloqueEntity;
import pe.com.unfpg.repository.BloqueRepository;
import pe.com.unfpg.service.BloqueService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class BloqueServiceImpl implements BloqueService {
    private final BloqueRepository repository;

    public BloqueServiceImpl(BloqueRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BloqueEntity> listar() {
        return repository.findAll(Sort.by("codblo"));
    }

    @Override
    public BloqueEntity buscarPorId(Integer codblo) {
        if (codblo == null || codblo <= 0) throw ConsultaGetException.idInvalido("codblo");
        return repository.findById(codblo)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("bloque"));
    }
}
