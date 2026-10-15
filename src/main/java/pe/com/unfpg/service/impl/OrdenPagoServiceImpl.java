package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.OrdenPagoEntity;
import pe.com.unfpg.repository.OrdenPagoRepository;
import pe.com.unfpg.service.OrdenPagoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class OrdenPagoServiceImpl implements OrdenPagoService {
    private final OrdenPagoRepository repository;

    public OrdenPagoServiceImpl(OrdenPagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OrdenPagoEntity> listar() {
        return repository.findAll(Sort.by("codordpag"));
    }

    @Override
    public OrdenPagoEntity buscarPorId(Integer codordpag) {
        if (codordpag == null || codordpag <= 0) throw ConsultaGetException.idInvalido("codordpag");
        return repository.findById(codordpag)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("ordenpago"));
    }
}
