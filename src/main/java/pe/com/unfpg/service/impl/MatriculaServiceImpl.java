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
import pe.com.unfpg.entity.EstadoMatriculaEntity;
import pe.com.unfpg.entity.MatriculaEntity;
import pe.com.unfpg.entity.PeriodoAcademicoEntity;
import pe.com.unfpg.entity.TipoMatriculaEntity;
import pe.com.unfpg.repository.MatriculaRepository;
import pe.com.unfpg.service.MatriculaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class MatriculaServiceImpl implements MatriculaService {
    private final MatriculaRepository repository;

    public MatriculaServiceImpl(MatriculaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MatriculaEntity> listar() {
        return repository.findAll(Sort.by("nummat"));
    }

    @Override
    public MatriculaEntity buscarPorId(Integer nummat) {
        if (nummat == null || nummat <= 0) throw ConsultaGetException.idInvalido("nummat");
        return repository.findById(nummat)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("matricula"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public MatriculaEntity actualizar(Integer nummat, MatriculaEntity datos) {
        if (nummat == null || nummat <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getCodalu() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codalu obligatorio");
        if (datos.getCodalu() != null && datos.getCodalu() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codalu invalida");
        if (datos.getCodalu() != null && entityManager.find(AlumnoEntity.class, datos.getCodalu()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codalu inexistente");
        if (datos.getCodestm() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codestm obligatorio");
        if (datos.getCodestm() != null && datos.getCodestm() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codestm invalida");
        if (datos.getCodestm() != null && entityManager.find(EstadoMatriculaEntity.class, datos.getCodestm()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codestm inexistente");
        if (datos.getCodtipm() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codtipm obligatorio");
        if (datos.getCodtipm() != null && datos.getCodtipm() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codtipm invalida");
        if (datos.getCodtipm() != null && entityManager.find(TipoMatriculaEntity.class, datos.getCodtipm()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codtipm inexistente");
        if (datos.getCodper() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codper obligatorio");
        if (datos.getCodper() != null && datos.getCodper() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codper invalida");
        if (datos.getCodper() != null && entityManager.find(PeriodoAcademicoEntity.class, datos.getCodper()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codper inexistente");
        if (datos.getEstmat() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estmat obligatorio");
        MatriculaEntity actual = repository.findById(nummat).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matricula no encontrado"));
        actual.setObsmat((datos.getObsmat() == null ? null : datos.getObsmat().trim()));
        actual.setCodalu(datos.getCodalu());
        actual.setCodestm(datos.getCodestm());
        actual.setCodtipm(datos.getCodtipm());
        actual.setCodper(datos.getCodper());
        actual.setEstmat(datos.getEstmat());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public MatriculaEntity deshabilitar(Integer nummat) {
        if (nummat == null || nummat <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        MatriculaEntity actual = repository.findById(nummat)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matricula no encontrado"));
        actual.setEstmat(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public MatriculaEntity habilitar(Integer nummat) {
        if (nummat == null || nummat <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        MatriculaEntity actual = repository.findById(nummat)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matricula no encontrado"));
        actual.setEstmat(true);
        return repository.save(actual);
    }
}
