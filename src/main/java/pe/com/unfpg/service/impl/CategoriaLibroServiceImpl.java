package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.CategoriaLibroEntity;
import pe.com.unfpg.repository.CategoriaLibroRepository;
import pe.com.unfpg.service.CategoriaLibroService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class CategoriaLibroServiceImpl implements CategoriaLibroService {
    private final CategoriaLibroRepository repository;

    public CategoriaLibroServiceImpl(CategoriaLibroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoriaLibroEntity> listar() {
        return repository.findAll(Sort.by("codcatl"));
    }

    @Override
    public CategoriaLibroEntity buscarPorId(Integer codcatl) {
        if (codcatl == null || codcatl <= 0) throw ConsultaGetException.idInvalido("codcatl");
        return repository.findById(codcatl)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("categorialibro"));
    }
}
