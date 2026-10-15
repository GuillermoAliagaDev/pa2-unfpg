package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.PagoEntity;
import pe.com.unfpg.repository.PagoRepository;
import pe.com.unfpg.service.PagoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class PagoServiceImpl implements PagoService {
    private final PagoRepository repository;

    public PagoServiceImpl(PagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PagoEntity> listar() {
        return repository.findAll(Sort.by("codpag"));
    }

    @Override
    public PagoEntity buscarPorId(Integer codpag) {
        if (codpag == null || codpag <= 0) throw ConsultaGetException.idInvalido("codpag");
        return repository.findById(codpag)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("pago"));
    }
}
