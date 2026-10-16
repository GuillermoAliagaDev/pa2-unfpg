package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.CursoEntity;
import pe.com.unfpg.entity.DocenteEntity;
import pe.com.unfpg.entity.PeriodoAcademicoEntity;
import pe.com.unfpg.entity.SeccionEntity;
import pe.com.unfpg.repository.SeccionRepository;
import pe.com.unfpg.service.SeccionService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class SeccionServiceImpl implements SeccionService {
    private final SeccionRepository repository;

    public SeccionServiceImpl(SeccionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SeccionEntity> listar() {
        return repository.findAll(Sort.by("codsec"));
    }

    @Override
    public SeccionEntity buscarPorId(Integer codsec) {
        if (codsec == null || codsec <= 0) throw ConsultaGetException.idInvalido("codsec");
        return repository.findById(codsec)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("seccion"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public SeccionEntity actualizar(Integer codsec, SeccionEntity datos) {
        if (codsec == null || codsec <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getCapsec() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo capsec obligatorio");
        if (datos.getCapsec() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo capsec invalido");
        if (datos.getCodcur() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codcur obligatorio");
        if (datos.getCodcur() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codcur invalido");
        if (datos.getCoddoc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo coddoc obligatorio");
        if (datos.getCoddoc() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo coddoc invalido");
        if (datos.getCodper() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codper obligatorio");
        if (datos.getCodper() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codper invalido");
        if (datos.getCodcur() != null && entityManager.find(CursoEntity.class, datos.getCodcur()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codcur inexistente");
        if (datos.getCoddoc() != null && entityManager.find(DocenteEntity.class, datos.getCoddoc()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia coddoc inexistente");
        if (datos.getCodper() != null && entityManager.find(PeriodoAcademicoEntity.class, datos.getCodper()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codper inexistente");
        SeccionEntity actual = repository.findById(codsec).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seccion no encontrado"));
        actual.setCapsec(datos.getCapsec());
        actual.setCodcur(datos.getCodcur());
        actual.setCoddoc(datos.getCoddoc());
        actual.setCodper(datos.getCodper());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public void eliminar(Integer codsec) {
        if (codsec == null || codsec <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        SeccionEntity actual = repository.findById(codsec)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seccion no encontrado"));
        repository.delete(actual);
    }
}
