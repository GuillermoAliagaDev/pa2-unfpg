package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.RolLmsEntity;
import pe.com.unfpg.repository.RolLmsRepository;
import pe.com.unfpg.service.RolLmsService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class RolLmsServiceImpl implements RolLmsService {
    private final RolLmsRepository repository;

    public RolLmsServiceImpl(RolLmsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RolLmsEntity> listar() {
        return repository.findAll(Sort.by("codroll"));
    }

    @Override
    public RolLmsEntity buscarPorId(Integer codroll) {
        if (codroll == null || codroll <= 0) throw ConsultaGetException.idInvalido("codroll");
        return repository.findById(codroll)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("rollms"));
    }
}
