package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.AsistenciaEntity;
import pe.com.unfpg.entity.DetalleMatriculaEntity;
import pe.com.unfpg.entity.SeccionEntity;
import pe.com.unfpg.repository.AsistenciaRepository;
import pe.com.unfpg.service.AsistenciaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class AsistenciaServiceImpl implements AsistenciaService {
    private final AsistenciaRepository repository;

    public AsistenciaServiceImpl(AsistenciaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AsistenciaEntity> listar() {
        return repository.findAll(Sort.by("codasis"));
    }

    @Override
    public AsistenciaEntity buscarPorId(Integer codasis) {
        if (codasis == null || codasis <= 0) throw ConsultaGetException.idInvalido("codasis");
        return repository.findById(codasis)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("asistencia"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public AsistenciaEntity actualizar(Integer codasis, AsistenciaEntity datos) {
        if (codasis == null || codasis <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getFecasis() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo fecasis obligatorio");
        if (datos.getPresente() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo presente obligatorio");
        if (datos.getJustificada() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo justificada obligatorio");
        if (datos.getCoddet() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo coddet obligatorio");
        if (datos.getCoddet() != null && datos.getCoddet() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia coddet invalida");
        if (datos.getCoddet() != null && entityManager.find(DetalleMatriculaEntity.class, datos.getCoddet()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia coddet inexistente");
        if (datos.getCodsec() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codsec obligatorio");
        if (datos.getCodsec() != null && datos.getCodsec() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codsec invalida");
        if (datos.getCodsec() != null && entityManager.find(SeccionEntity.class, datos.getCodsec()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codsec inexistente");
        AsistenciaEntity actual = repository.findById(codasis).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asistencia no encontrado"));
        actual.setFecasis(datos.getFecasis());
        actual.setPresente(datos.getPresente());
        actual.setJustificada(datos.getJustificada());
        actual.setCoddet(datos.getCoddet());
        actual.setCodsec(datos.getCodsec());
        return repository.save(actual);
    }
}
