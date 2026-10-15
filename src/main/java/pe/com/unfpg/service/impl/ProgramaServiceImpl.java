package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.ProgramaEntity;
import pe.com.unfpg.repository.ProgramaRepository;
import pe.com.unfpg.service.ProgramaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class ProgramaServiceImpl implements ProgramaService {
    private final ProgramaRepository repository;

    public ProgramaServiceImpl(ProgramaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProgramaEntity> listar() {
        return repository.findAll(Sort.by("codprog"));
    }

    @Override
    public ProgramaEntity buscarPorId(Integer codprog) {
        if (codprog == null || codprog <= 0) throw ConsultaGetException.idInvalido("codprog");
        return repository.findById(codprog)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("programa"));
    }
}
