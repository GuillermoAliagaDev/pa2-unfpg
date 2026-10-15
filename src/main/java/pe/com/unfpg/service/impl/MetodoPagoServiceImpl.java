package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.MetodoPagoEntity;
import pe.com.unfpg.repository.MetodoPagoRepository;
import pe.com.unfpg.service.MetodoPagoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class MetodoPagoServiceImpl implements MetodoPagoService {
    private final MetodoPagoRepository repository;

    public MetodoPagoServiceImpl(MetodoPagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MetodoPagoEntity> listar() {
        return repository.findAll(Sort.by("codmetp"));
    }

    @Override
    public MetodoPagoEntity buscarPorId(Integer codmetp) {
        if (codmetp == null || codmetp <= 0) throw ConsultaGetException.idInvalido("codmetp");
        return repository.findById(codmetp)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("metodopago"));
    }
}
