package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.TipoDocumentoEntity;
import pe.com.unfpg.repository.TipoDocumentoRepository;
import pe.com.unfpg.service.TipoDocumentoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
    private final TipoDocumentoRepository repository;

    public TipoDocumentoServiceImpl(TipoDocumentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TipoDocumentoEntity> listar() {
        return repository.findAll(Sort.by("codtipd"));
    }

    @Override
    public TipoDocumentoEntity buscarPorId(Integer codtipd) {
        if (codtipd == null || codtipd <= 0) throw ConsultaGetException.idInvalido("codtipd");
        return repository.findById(codtipd)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("tipodocumento"));
    }
}
