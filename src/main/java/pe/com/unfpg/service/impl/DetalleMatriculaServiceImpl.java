package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.DetalleMatriculaEntity;
import pe.com.unfpg.entity.MatriculaEntity;
import pe.com.unfpg.entity.SeccionEntity;
import pe.com.unfpg.repository.DetalleMatriculaRepository;
import pe.com.unfpg.service.DetalleMatriculaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class DetalleMatriculaServiceImpl implements DetalleMatriculaService {
    private final DetalleMatriculaRepository repository;

    public DetalleMatriculaServiceImpl(DetalleMatriculaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DetalleMatriculaEntity> listar() {
        return repository.findAll(Sort.by("coddet"));
    }

    @Override
    public DetalleMatriculaEntity buscarPorId(Integer coddet) {
        if (coddet == null || coddet <= 0) throw ConsultaGetException.idInvalido("coddet");
        return repository.findById(coddet)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("detallematricula"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public DetalleMatriculaEntity actualizar(Integer coddet, DetalleMatriculaEntity datos) {
        if (coddet == null || coddet <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getEstdet() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estdet obligatorio");
        if (datos.getNummat() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nummat obligatorio");
        if (datos.getNummat() != null && datos.getNummat() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia nummat invalida");
        if (datos.getNummat() != null && entityManager.find(MatriculaEntity.class, datos.getNummat()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia nummat inexistente");
        if (datos.getCodsec() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codsec obligatorio");
        if (datos.getCodsec() != null && datos.getCodsec() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codsec invalida");
        if (datos.getCodsec() != null && entityManager.find(SeccionEntity.class, datos.getCodsec()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codsec inexistente");
        DetalleMatriculaEntity actual = repository.findById(coddet).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "DetalleMatricula no encontrado"));
        actual.setEstdet(datos.getEstdet());
        actual.setNummat(datos.getNummat());
        actual.setCodsec(datos.getCodsec());
        return repository.save(actual);
    }
}
