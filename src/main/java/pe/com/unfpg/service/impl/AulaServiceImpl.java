package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.AulaEntity;
import pe.com.unfpg.repository.AulaRepository;
import pe.com.unfpg.service.AulaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class AulaServiceImpl implements AulaService {
    private final AulaRepository repository;

    public AulaServiceImpl(AulaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AulaEntity> listar() {
        return repository.findAll(Sort.by("codaul"));
    }

    @Override
    public AulaEntity buscarPorId(Integer codaul) {
        if (codaul == null || codaul <= 0) throw ConsultaGetException.idInvalido("codaul");
        return repository.findById(codaul)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("aula"));
    }
}
