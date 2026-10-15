package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.RolEntity;
import pe.com.unfpg.repository.RolRepository;
import pe.com.unfpg.service.RolService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class RolServiceImpl implements RolService {
    private final RolRepository repository;

    public RolServiceImpl(RolRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RolEntity> listar() {
        return repository.findAll(Sort.by("codrol"));
    }

    @Override
    public RolEntity buscarPorId(Integer codrol) {
        if (codrol == null || codrol <= 0) throw ConsultaGetException.idInvalido("codrol");
        return repository.findById(codrol)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("rol"));
    }
}
