package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.AlumnoEntity;
import pe.com.unfpg.entity.CursoLmsEntity;
import pe.com.unfpg.entity.MatriculaLmsEntity;
import pe.com.unfpg.entity.RolLmsEntity;
import pe.com.unfpg.repository.MatriculaLmsRepository;
import pe.com.unfpg.service.MatriculaLmsService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class MatriculaLmsServiceImpl implements MatriculaLmsService {
    private final MatriculaLmsRepository repository;

    public MatriculaLmsServiceImpl(MatriculaLmsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MatriculaLmsEntity> listar() {
        return repository.findAll(Sort.by("nummatl"));
    }

    @Override
    public MatriculaLmsEntity buscarPorId(Integer nummatl) {
        if (nummatl == null || nummatl <= 0) throw ConsultaGetException.idInvalido("nummatl");
        return repository.findById(nummatl)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("matriculalms"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public MatriculaLmsEntity actualizar(Integer nummatl, MatriculaLmsEntity datos) {
        if (nummatl == null || nummatl <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getEstmatl() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estmatl obligatorio");
        if (datos.getCodalu() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codalu obligatorio");
        if (datos.getCodalu() != null && datos.getCodalu() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codalu invalida");
        if (datos.getCodalu() != null && entityManager.find(AlumnoEntity.class, datos.getCodalu()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codalu inexistente");
        if (datos.getCodcurl() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codcurl obligatorio");
        if (datos.getCodcurl() != null && datos.getCodcurl() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codcurl invalida");
        if (datos.getCodcurl() != null && entityManager.find(CursoLmsEntity.class, datos.getCodcurl()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codcurl inexistente");
        if (datos.getCodroll() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codroll obligatorio");
        if (datos.getCodroll() != null && datos.getCodroll() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codroll invalida");
        if (datos.getCodroll() != null && entityManager.find(RolLmsEntity.class, datos.getCodroll()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codroll inexistente");
        MatriculaLmsEntity actual = repository.findById(nummatl).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "MatriculaLms no encontrado"));
        actual.setEstmatl(datos.getEstmatl());
        actual.setCodalu(datos.getCodalu());
        actual.setCodcurl(datos.getCodcurl());
        actual.setCodroll(datos.getCodroll());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public MatriculaLmsEntity deshabilitar(Integer nummatl) {
        if (nummatl == null || nummatl <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        MatriculaLmsEntity actual = repository.findById(nummatl)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "MatriculaLms no encontrado"));
        actual.setEstmatl(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public MatriculaLmsEntity habilitar(Integer nummatl) {
        if (nummatl == null || nummatl <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        MatriculaLmsEntity actual = repository.findById(nummatl)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "MatriculaLms no encontrado"));
        actual.setEstmatl(true);
        return repository.save(actual);
    }
}
