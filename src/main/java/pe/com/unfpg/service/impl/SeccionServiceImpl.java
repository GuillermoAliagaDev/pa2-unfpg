package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.SeccionEntity;
import pe.com.unfpg.repository.SeccionRepository;
import pe.com.unfpg.service.SeccionService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class SeccionServiceImpl implements SeccionService {
    private final SeccionRepository repository;

    public SeccionServiceImpl(SeccionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SeccionEntity> listar() {
        return repository.findAll(Sort.by("codsec"));
    }

    @Override
    public SeccionEntity buscarPorId(Integer codsec) {
        if (codsec == null || codsec <= 0) throw ConsultaGetException.idInvalido("codsec");
        return repository.findById(codsec)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("seccion"));
    }
}
