package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.AsistenciaEntity;
import pe.com.unfpg.repository.AsistenciaRepository;
import pe.com.unfpg.service.AsistenciaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class AsistenciaServiceImpl implements AsistenciaService {
    private final AsistenciaRepository repository;

    public AsistenciaServiceImpl(AsistenciaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AsistenciaEntity> listar() {
        return repository.findAll(Sort.by("codasis"));
    }

    @Override
    public AsistenciaEntity buscarPorId(Integer codasis) {
        if (codasis == null || codasis <= 0) throw ConsultaGetException.idInvalido("codasis");
        return repository.findById(codasis)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("asistencia"));
    }
}
