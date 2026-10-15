package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.DocenteEntity;
import pe.com.unfpg.repository.DocenteRepository;
import pe.com.unfpg.service.DocenteService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class DocenteServiceImpl implements DocenteService {
    private final DocenteRepository repository;

    public DocenteServiceImpl(DocenteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DocenteEntity> listar() {
        return repository.findAll(Sort.by("coddoc"));
    }

    @Override
    public DocenteEntity buscarPorId(Integer coddoc) {
        if (coddoc == null || coddoc <= 0) throw ConsultaGetException.idInvalido("coddoc");
        return repository.findById(coddoc)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("docente"));
    }
}
