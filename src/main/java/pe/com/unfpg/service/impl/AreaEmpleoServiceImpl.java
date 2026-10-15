package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.AreaEmpleoEntity;
import pe.com.unfpg.repository.AreaEmpleoRepository;
import pe.com.unfpg.service.AreaEmpleoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class AreaEmpleoServiceImpl implements AreaEmpleoService {
    private final AreaEmpleoRepository repository;

    public AreaEmpleoServiceImpl(AreaEmpleoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AreaEmpleoEntity> listar() {
        return repository.findAll(Sort.by("codare"));
    }

    @Override
    public AreaEmpleoEntity buscarPorId(Integer codare) {
        if (codare == null || codare <= 0) throw ConsultaGetException.idInvalido("codare");
        return repository.findById(codare)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("areaempleo"));
    }
}
