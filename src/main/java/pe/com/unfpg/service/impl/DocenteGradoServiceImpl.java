package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.DocenteGradoEntity;
import pe.com.unfpg.entity.DocenteGradoId;
import pe.com.unfpg.repository.DocenteGradoRepository;
import pe.com.unfpg.service.DocenteGradoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class DocenteGradoServiceImpl implements DocenteGradoService {
    private final DocenteGradoRepository repository;

    public DocenteGradoServiceImpl(DocenteGradoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DocenteGradoEntity> listar() {
        return repository.findAll(Sort.by("coddoc", "codgrai"));
    }

    @Override
    public DocenteGradoEntity buscarPorId(Integer coddoc, Integer codgrai) {
        if (coddoc == null || coddoc <= 0) throw ConsultaGetException.idInvalido("coddoc");
        if (codgrai == null || codgrai <= 0) throw ConsultaGetException.idInvalido("codgrai");
        return repository.findById(new DocenteGradoId(coddoc, codgrai))
            .orElseThrow(() -> ConsultaGetException.noEncontrado("docentegrado"));
    }
}
