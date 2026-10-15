package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.CursoLmsEntity;
import pe.com.unfpg.repository.CursoLmsRepository;
import pe.com.unfpg.service.CursoLmsService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class CursoLmsServiceImpl implements CursoLmsService {
    private final CursoLmsRepository repository;

    public CursoLmsServiceImpl(CursoLmsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CursoLmsEntity> listar() {
        return repository.findAll(Sort.by("codcurl"));
    }

    @Override
    public CursoLmsEntity buscarPorId(Integer codcurl) {
        if (codcurl == null || codcurl <= 0) throw ConsultaGetException.idInvalido("codcurl");
        return repository.findById(codcurl)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("cursolms"));
    }
}
