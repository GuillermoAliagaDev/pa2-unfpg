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
import pe.com.unfpg.entity.PlanEstudioEntity;
import pe.com.unfpg.entity.SeccionEntity;
import pe.com.unfpg.repository.CursoLmsRepository;
import pe.com.unfpg.service.CursoLmsService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class CursoLmsServiceImpl implements CursoLmsService {
    private final CursoLmsRepository repository;

    public CursoLmsServiceImpl(CursoLmsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CursoLmsEntity> listar() {
        return repository.findAll(Sort.by("codcurl"));
    }

    @Override
    public CursoLmsEntity buscarPorId(Integer codcurl) {
        if (codcurl == null || codcurl <= 0) throw ConsultaGetException.idInvalido("codcurl");
        return repository.findById(codcurl)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("cursolms"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public CursoLmsEntity actualizar(Integer codcurl, CursoLmsEntity datos) {
        if (codcurl == null || codcurl <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getCodpla() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codpla obligatorio");
        if (datos.getCodpla() != null && datos.getCodpla() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codpla invalida");
        if (datos.getCodpla() != null && entityManager.find(PlanEstudioEntity.class, datos.getCodpla()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codpla inexistente");
        if (datos.getEstcurl() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estcurl obligatorio");
        if (datos.getCodsec() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codsec obligatorio");
        if (datos.getCodsec() != null && datos.getCodsec() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codsec invalida");
        if (datos.getCodsec() != null && entityManager.find(SeccionEntity.class, datos.getCodsec()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codsec inexistente");
        CursoLmsEntity actual = repository.findById(codcurl).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CursoLms no encontrado"));
        actual.setCodpla(datos.getCodpla());
        actual.setEstcurl(datos.getEstcurl());
        actual.setCodsec(datos.getCodsec());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public CursoLmsEntity deshabilitar(Integer codcurl) {
        if (codcurl == null || codcurl <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        CursoLmsEntity actual = repository.findById(codcurl)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CursoLms no encontrado"));
        actual.setEstcurl(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public CursoLmsEntity habilitar(Integer codcurl) {
        if (codcurl == null || codcurl <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        CursoLmsEntity actual = repository.findById(codcurl)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CursoLms no encontrado"));
        actual.setEstcurl(true);
        return repository.save(actual);
    }
}
