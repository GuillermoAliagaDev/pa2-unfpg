package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.PrestamoLibroEntity;
import pe.com.unfpg.repository.PrestamoLibroRepository;
import pe.com.unfpg.service.PrestamoLibroService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class PrestamoLibroServiceImpl implements PrestamoLibroService {
    private final PrestamoLibroRepository repository;

    public PrestamoLibroServiceImpl(PrestamoLibroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PrestamoLibroEntity> listar() {
        return repository.findAll(Sort.by("numpre"));
    }

    @Override
    public PrestamoLibroEntity buscarPorId(Integer numpre) {
        if (numpre == null || numpre <= 0) throw ConsultaGetException.idInvalido("numpre");
        return repository.findById(numpre)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("prestamolibro"));
    }
}
