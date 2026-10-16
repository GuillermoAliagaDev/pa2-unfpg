package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.PlanEstudioEntity;
import pe.com.unfpg.entity.ProgramaEntity;
import pe.com.unfpg.repository.PlanEstudioRepository;
import pe.com.unfpg.service.PlanEstudioService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class PlanEstudioServiceImpl implements PlanEstudioService {
    private final PlanEstudioRepository repository;

    public PlanEstudioServiceImpl(PlanEstudioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PlanEstudioEntity> listar() {
        return repository.findAll(Sort.by("codpla"));
    }

    @Override
    public PlanEstudioEntity buscarPorId(Integer codpla) {
        if (codpla == null || codpla <= 0) throw ConsultaGetException.idInvalido("codpla");
        return repository.findById(codpla)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("planestudio"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public PlanEstudioEntity actualizar(Integer codpla, PlanEstudioEntity datos) {
        if (codpla == null || codpla <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getNompla() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nompla obligatorio");
        if (datos.getNompla().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nompla vacio");
        if (datos.getNompla() != null && datos.getNompla().length() > 100) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nompla demasiado largo");
        if (datos.getEstpla() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estpla obligatorio");
        if (datos.getCodprog() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codprog obligatorio");
        if (datos.getCodprog() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codprog invalido");
        if (datos.getCodprog() != null && entityManager.find(ProgramaEntity.class, datos.getCodprog()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codprog inexistente");
        PlanEstudioEntity actual = repository.findById(codpla).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PlanEstudio no encontrado"));
        actual.setNompla(datos.getNompla().trim());
        actual.setDespla(datos.getDespla());
        actual.setEstpla(datos.getEstpla());
        actual.setCodprog(datos.getCodprog());
        return repository.save(actual);
    }
}
