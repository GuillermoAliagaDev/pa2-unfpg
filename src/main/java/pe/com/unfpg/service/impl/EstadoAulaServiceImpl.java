package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.EstadoAulaEntity;
import pe.com.unfpg.repository.EstadoAulaRepository;
import pe.com.unfpg.service.EstadoAulaService;
import pe.com.unfpg.exception.ConsultaGetException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
@Transactional(readOnly = true)
public class EstadoAulaServiceImpl implements EstadoAulaService {
    private final EstadoAulaRepository repository;

    public EstadoAulaServiceImpl(EstadoAulaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EstadoAulaEntity> listar() {
        return repository.findAll(Sort.by("codesta"));
    }

    @Override
    public EstadoAulaEntity buscarPorId(Integer codesta) {
        if (codesta == null || codesta <= 0) throw ConsultaGetException.idInvalido("codesta");
        return repository.findById(codesta)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("estadoaula"));
    }
    
    @Override
    @Transactional
    public EstadoAulaEntity actualizar(Integer codesta, EstadoAulaEntity datos) {
        if (codesta == null || codesta <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null || datos.getNomesta() == null
                || datos.getNomesta().trim().isEmpty()
                || datos.getNomesta().trim().length() > 50
                || datos.getEstesta() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos");
        }
        EstadoAulaEntity actual = repository.findById(codesta)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
        actual.setNomesta(datos.getNomesta().trim());
        actual.setEstesta(datos.getEstesta());
        return repository.save(actual);
    }

}
