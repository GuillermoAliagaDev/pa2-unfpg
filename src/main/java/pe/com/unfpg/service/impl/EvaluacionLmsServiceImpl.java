package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.CursoLmsEntity;
import pe.com.unfpg.entity.EvaluacionLmsEntity;
import pe.com.unfpg.repository.EvaluacionLmsRepository;
import pe.com.unfpg.service.EvaluacionLmsService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EvaluacionLmsServiceImpl implements EvaluacionLmsService {
    private final EvaluacionLmsRepository repository;

    public EvaluacionLmsServiceImpl(EvaluacionLmsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EvaluacionLmsEntity> listar() {
        return repository.findAll(Sort.by("codeval"));
    }

    @Override
    public EvaluacionLmsEntity buscarPorId(Integer codeval) {
        if (codeval == null || codeval <= 0) throw ConsultaGetException.idInvalido("codeval");
        return repository.findById(codeval)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("evaluacionlms"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public EvaluacionLmsEntity actualizar(Integer codeval, EvaluacionLmsEntity datos) {
        if (codeval == null || codeval <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getNomeval() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomeval obligatorio");
        if (datos.getNomeval().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomeval vacio");
        if (datos.getNomeval() != null && datos.getNomeval().length() > 100) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomeval demasiado largo");
        if (datos.getFeceval() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo feceval obligatorio");
        if (datos.getEsteval() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo esteval obligatorio");
        if (datos.getCodcurl() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codcurl obligatorio");
        if (datos.getCodcurl() != null && datos.getCodcurl() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codcurl invalida");
        if (datos.getCodcurl() != null && entityManager.find(CursoLmsEntity.class, datos.getCodcurl()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codcurl inexistente");
        EvaluacionLmsEntity actual = repository.findById(codeval).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EvaluacionLms no encontrado"));
        actual.setNomeval(datos.getNomeval().trim());
        actual.setDeseval((datos.getDeseval() == null ? null : datos.getDeseval().trim()));
        actual.setFeceval(datos.getFeceval());
        actual.setEsteval(datos.getEsteval());
        actual.setCodcurl(datos.getCodcurl());
        return repository.save(actual);
    }
}
