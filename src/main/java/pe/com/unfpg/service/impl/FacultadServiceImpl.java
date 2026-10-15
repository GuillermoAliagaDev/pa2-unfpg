package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.FacultadEntity;
import pe.com.unfpg.repository.FacultadRepository;
import pe.com.unfpg.service.FacultadService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class FacultadServiceImpl implements FacultadService {
    private final FacultadRepository repository;

    public FacultadServiceImpl(FacultadRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FacultadEntity> listar() {
        return repository.findAll(Sort.by("codfac"));
    }

    @Override
    public FacultadEntity buscarPorId(Integer codfac) {
        if (codfac == null || codfac <= 0) throw ConsultaGetException.idInvalido("codfac");
        return repository.findById(codfac)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("facultad"));
    }
}
