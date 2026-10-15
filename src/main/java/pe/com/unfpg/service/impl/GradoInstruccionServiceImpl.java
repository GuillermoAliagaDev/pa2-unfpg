package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.GradoInstruccionEntity;
import pe.com.unfpg.repository.GradoInstruccionRepository;
import pe.com.unfpg.service.GradoInstruccionService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class GradoInstruccionServiceImpl implements GradoInstruccionService {
    private final GradoInstruccionRepository repository;

    public GradoInstruccionServiceImpl(GradoInstruccionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GradoInstruccionEntity> listar() {
        return repository.findAll(Sort.by("codgrai"));
    }

    @Override
    public GradoInstruccionEntity buscarPorId(Integer codgrai) {
        if (codgrai == null || codgrai <= 0) throw ConsultaGetException.idInvalido("codgrai");
        return repository.findById(codgrai)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("gradoinstruccion"));
    }
}
