package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.CursoEntity;
import pe.com.unfpg.repository.CursoRepository;
import pe.com.unfpg.service.CursoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class CursoServiceImpl implements CursoService {
    private final CursoRepository repository;

    public CursoServiceImpl(CursoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CursoEntity> listar() {
        return repository.findAll(Sort.by("codcur"));
    }

    @Override
    public CursoEntity buscarPorId(Integer codcur) {
        if (codcur == null || codcur <= 0) throw ConsultaGetException.idInvalido("codcur");
        return repository.findById(codcur)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("curso"));
    }
}
