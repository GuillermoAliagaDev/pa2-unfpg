package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.DiaSemanaEntity;
import pe.com.unfpg.repository.DiaSemanaRepository;
import pe.com.unfpg.service.DiaSemanaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class DiaSemanaServiceImpl implements DiaSemanaService {
    private final DiaSemanaRepository repository;

    public DiaSemanaServiceImpl(DiaSemanaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DiaSemanaEntity> listar() {
        return repository.findAll(Sort.by("coddias"));
    }

    @Override
    public DiaSemanaEntity buscarPorId(Integer coddias) {
        if (coddias == null || coddias <= 0) throw ConsultaGetException.idInvalido("coddias");
        return repository.findById(coddias)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("diasemana"));
    }
}
