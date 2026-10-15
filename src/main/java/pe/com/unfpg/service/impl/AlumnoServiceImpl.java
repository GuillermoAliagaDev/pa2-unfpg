package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.AlumnoEntity;
import pe.com.unfpg.repository.AlumnoRepository;
import pe.com.unfpg.service.AlumnoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class AlumnoServiceImpl implements AlumnoService {
    private final AlumnoRepository repository;

    public AlumnoServiceImpl(AlumnoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AlumnoEntity> listar() {
        return repository.findAll(Sort.by("codalu"));
    }

    @Override
    public AlumnoEntity buscarPorId(Integer codalu) {
        if (codalu == null || codalu <= 0) throw ConsultaGetException.idInvalido("codalu");
        return repository.findById(codalu)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("alumno"));
    }
}
