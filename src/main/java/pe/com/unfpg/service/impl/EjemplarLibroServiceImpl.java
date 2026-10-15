package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.EjemplarLibroEntity;
import pe.com.unfpg.repository.EjemplarLibroRepository;
import pe.com.unfpg.service.EjemplarLibroService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EjemplarLibroServiceImpl implements EjemplarLibroService {
    private final EjemplarLibroRepository repository;

    public EjemplarLibroServiceImpl(EjemplarLibroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EjemplarLibroEntity> listar() {
        return repository.findAll(Sort.by("codeje"));
    }

    @Override
    public EjemplarLibroEntity buscarPorId(Integer codeje) {
        if (codeje == null || codeje <= 0) throw ConsultaGetException.idInvalido("codeje");
        return repository.findById(codeje)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("ejemplarlibro"));
    }
}
