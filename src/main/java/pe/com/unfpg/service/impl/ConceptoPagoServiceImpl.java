package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.ConceptoPagoEntity;
import pe.com.unfpg.repository.ConceptoPagoRepository;
import pe.com.unfpg.service.ConceptoPagoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class ConceptoPagoServiceImpl implements ConceptoPagoService {
    private final ConceptoPagoRepository repository;

    public ConceptoPagoServiceImpl(ConceptoPagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ConceptoPagoEntity> listar() {
        return repository.findAll(Sort.by("codconp"));
    }

    @Override
    public ConceptoPagoEntity buscarPorId(Integer codconp) {
        if (codconp == null || codconp <= 0) throw ConsultaGetException.idInvalido("codconp");
        return repository.findById(codconp)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("conceptopago"));
    }
}
