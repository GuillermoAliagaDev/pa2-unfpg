package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.CalificacionEntity;
import pe.com.unfpg.entity.DetalleMatriculaEntity;
import pe.com.unfpg.entity.SeccionEntity;
import pe.com.unfpg.entity.TipoCalificacionEntity;
import pe.com.unfpg.repository.CalificacionRepository;
import pe.com.unfpg.service.CalificacionService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class CalificacionServiceImpl implements CalificacionService {
    private final CalificacionRepository repository;

    public CalificacionServiceImpl(CalificacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CalificacionEntity> listar() {
        return repository.findAll(Sort.by("codcal"));
    }

    @Override
    public CalificacionEntity buscarPorId(Integer codcal) {
        if (codcal == null || codcal <= 0) throw ConsultaGetException.idInvalido("codcal");
        return repository.findById(codcal)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("calificacion"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public CalificacionEntity actualizar(Integer codcal, CalificacionEntity datos) {
        if (codcal == null || codcal <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getFeccal() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo feccal obligatorio");
        if (datos.getNota() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nota obligatorio");
        if (datos.getCoddet() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo coddet obligatorio");
        if (datos.getCoddet() != null && datos.getCoddet() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia coddet invalida");
        if (datos.getCoddet() != null && entityManager.find(DetalleMatriculaEntity.class, datos.getCoddet()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia coddet inexistente");
        if (datos.getCodsec() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codsec obligatorio");
        if (datos.getCodsec() != null && datos.getCodsec() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codsec invalida");
        if (datos.getCodsec() != null && entityManager.find(SeccionEntity.class, datos.getCodsec()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codsec inexistente");
        if (datos.getCodtipc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codtipc obligatorio");
        if (datos.getCodtipc() != null && datos.getCodtipc() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codtipc invalida");
        if (datos.getCodtipc() != null && entityManager.find(TipoCalificacionEntity.class, datos.getCodtipc()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codtipc inexistente");
        CalificacionEntity actual = repository.findById(codcal).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Calificacion no encontrado"));
        actual.setFeccal(datos.getFeccal());
        actual.setNota(datos.getNota());
        actual.setCoddet(datos.getCoddet());
        actual.setCodsec(datos.getCodsec());
        actual.setCodtipc(datos.getCodtipc());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public void eliminar(Integer codcal) {
        if (codcal == null || codcal <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        CalificacionEntity actual = repository.findById(codcal)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Calificacion no encontrado"));
        repository.delete(actual);
    }
}
