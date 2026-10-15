package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.LibroEntity;
import pe.com.unfpg.repository.LibroRepository;
import pe.com.unfpg.service.LibroService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class LibroServiceImpl implements LibroService {
    private final LibroRepository repository;

    public LibroServiceImpl(LibroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LibroEntity> listar() {
        return repository.findAll(Sort.by("codlib"));
    }

    @Override
    public LibroEntity buscarPorId(Integer codlib) {
        if (codlib == null || codlib <= 0) throw ConsultaGetException.idInvalido("codlib");
        return repository.findById(codlib)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("libro"));
    }
}
