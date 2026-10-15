package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.HorarioEntity;
import pe.com.unfpg.repository.HorarioRepository;
import pe.com.unfpg.service.HorarioService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class HorarioServiceImpl implements HorarioService {
    private final HorarioRepository repository;

    public HorarioServiceImpl(HorarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<HorarioEntity> listar() {
        return repository.findAll(Sort.by("codhor"));
    }

    @Override
    public HorarioEntity buscarPorId(Integer codhor) {
        if (codhor == null || codhor <= 0) throw ConsultaGetException.idInvalido("codhor");
        return repository.findById(codhor)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("horario"));
    }
}
