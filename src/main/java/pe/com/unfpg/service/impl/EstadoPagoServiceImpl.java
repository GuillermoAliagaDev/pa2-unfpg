package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.EstadoPagoEntity;
import pe.com.unfpg.repository.EstadoPagoRepository;
import pe.com.unfpg.service.EstadoPagoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EstadoPagoServiceImpl implements EstadoPagoService {
    private final EstadoPagoRepository repository;

    public EstadoPagoServiceImpl(EstadoPagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EstadoPagoEntity> listar() {
        return repository.findAll(Sort.by("codestp"));
    }

    @Override
    public EstadoPagoEntity buscarPorId(Integer codestp) {
        if (codestp == null || codestp <= 0) throw ConsultaGetException.idInvalido("codestp");
        return repository.findById(codestp)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("estadopago"));
    }
}
