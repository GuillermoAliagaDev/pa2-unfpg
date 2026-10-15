package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.EstadoPrestamoLibroEntity;
import pe.com.unfpg.repository.EstadoPrestamoLibroRepository;
import pe.com.unfpg.service.EstadoPrestamoLibroService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EstadoPrestamoLibroServiceImpl implements EstadoPrestamoLibroService {
    private final EstadoPrestamoLibroRepository repository;

    public EstadoPrestamoLibroServiceImpl(EstadoPrestamoLibroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EstadoPrestamoLibroEntity> listar() {
        return repository.findAll(Sort.by("codestl"));
    }

    @Override
    public EstadoPrestamoLibroEntity buscarPorId(Integer codestl) {
        if (codestl == null || codestl <= 0) throw ConsultaGetException.idInvalido("codestl");
        return repository.findById(codestl)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("estadoprestamolibro"));
    }
}
