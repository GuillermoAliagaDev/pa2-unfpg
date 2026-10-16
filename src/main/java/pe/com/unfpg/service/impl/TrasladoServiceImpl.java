package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.MatriculaEntity;
import pe.com.unfpg.entity.TrasladoEntity;
import pe.com.unfpg.repository.TrasladoRepository;
import pe.com.unfpg.service.TrasladoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class TrasladoServiceImpl implements TrasladoService {
    private final TrasladoRepository repository;

    public TrasladoServiceImpl(TrasladoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TrasladoEntity> listar() {
        return repository.findAll(Sort.by("codtra"));
    }

    @Override
    public TrasladoEntity buscarPorId(Integer codtra) {
        if (codtra == null || codtra <= 0) throw ConsultaGetException.idInvalido("codtra");
        return repository.findById(codtra)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("traslado"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public TrasladoEntity actualizar(Integer codtra, TrasladoEntity datos) {
        if (codtra == null || codtra <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getProgori() != null && datos.getProgori().length() > 100) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo progori demasiado largo");
        if (datos.getUniori() != null && datos.getUniori().length() > 100) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo uniori demasiado largo");
        if (datos.getEsttras() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo esttras obligatorio");
        if (datos.getNummat() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nummat obligatorio");
        if (datos.getNummat() != null && datos.getNummat() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia nummat invalida");
        if (datos.getNummat() != null && entityManager.find(MatriculaEntity.class, datos.getNummat()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia nummat inexistente");
        TrasladoEntity actual = repository.findById(codtra).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Traslado no encontrado"));
        actual.setProgori((datos.getProgori() == null ? null : datos.getProgori().trim()));
        actual.setUniori((datos.getUniori() == null ? null : datos.getUniori().trim()));
        actual.setEsttras(datos.getEsttras());
        actual.setNummat(datos.getNummat());
        return repository.save(actual);
    }
}
