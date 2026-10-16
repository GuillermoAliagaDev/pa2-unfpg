package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.EstadoMatriculaEntity;
import pe.com.unfpg.repository.EstadoMatriculaRepository;
import pe.com.unfpg.service.EstadoMatriculaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EstadoMatriculaServiceImpl implements EstadoMatriculaService {
    private final EstadoMatriculaRepository repository;

    public EstadoMatriculaServiceImpl(EstadoMatriculaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EstadoMatriculaEntity> listar() {
        return repository.findAll(Sort.by("codestm"));
    }

    @Override
    public EstadoMatriculaEntity buscarPorId(Integer codestm) {
        if (codestm == null || codestm <= 0) throw ConsultaGetException.idInvalido("codestm");
        return repository.findById(codestm)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("estadomatricula"));
    }
    
    @Override
    @Transactional
    public EstadoMatriculaEntity actualizar(Integer codestm, EstadoMatriculaEntity datos) {
        if (codestm == null || codestm <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null || datos.getNomestm() == null
                || datos.getNomestm().trim().isEmpty()
                || datos.getNomestm().trim().length() > 30
                || datos.getEstestm() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos");
        }
        EstadoMatriculaEntity actual = repository.findById(codestm)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
        actual.setNomestm(datos.getNomestm().trim());
        actual.setEstestm(datos.getEstestm());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public EstadoMatriculaEntity deshabilitar(Integer codestm) {
        if (codestm == null || codestm <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        EstadoMatriculaEntity actual = repository.findById(codestm)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EstadoMatricula no encontrado"));
        actual.setEstestm(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public EstadoMatriculaEntity habilitar(Integer codestm) {
        if (codestm == null || codestm <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        EstadoMatriculaEntity actual = repository.findById(codestm)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EstadoMatricula no encontrado"));
        actual.setEstestm(true);
        return repository.save(actual);
    }
}
