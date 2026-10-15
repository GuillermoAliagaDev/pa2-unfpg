package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.UbicacionEntity;
import pe.com.unfpg.repository.UbicacionRepository;
import pe.com.unfpg.service.UbicacionService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class UbicacionServiceImpl implements UbicacionService {
    private final UbicacionRepository repository;

    public UbicacionServiceImpl(UbicacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UbicacionEntity> listar() {
        return repository.findAll(Sort.by("codubi"));
    }

    @Override
    public UbicacionEntity buscarPorId(Integer codubi) {
        if (codubi == null || codubi <= 0) throw ConsultaGetException.idInvalido("codubi");
        return repository.findById(codubi)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("ubicacion"));
    }
}
