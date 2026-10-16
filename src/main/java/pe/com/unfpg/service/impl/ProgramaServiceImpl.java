package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.FacultadEntity;
import pe.com.unfpg.entity.ProgramaEntity;
import pe.com.unfpg.repository.ProgramaRepository;
import pe.com.unfpg.service.ProgramaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class ProgramaServiceImpl implements ProgramaService {
    private final ProgramaRepository repository;

    public ProgramaServiceImpl(ProgramaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProgramaEntity> listar() {
        return repository.findAll(Sort.by("codprog"));
    }

    @Override
    public ProgramaEntity buscarPorId(Integer codprog) {
        if (codprog == null || codprog <= 0) throw ConsultaGetException.idInvalido("codprog");
        return repository.findById(codprog)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("programa"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public ProgramaEntity actualizar(Integer codprog, ProgramaEntity datos) {
        if (codprog == null || codprog <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getNomprog() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomprog obligatorio");
        if (datos.getNomprog().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomprog vacio");
        if (datos.getNomprog() != null && datos.getNomprog().length() > 100) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomprog demasiado largo");
        if (datos.getEstprog() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estprog obligatorio");
        if (datos.getCodfac() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codfac obligatorio");
        if (datos.getCodfac() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codfac invalido");
        if (datos.getCodfac() != null && entityManager.find(FacultadEntity.class, datos.getCodfac()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codfac inexistente");
        ProgramaEntity actual = repository.findById(codprog).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Programa no encontrado"));
        actual.setNomprog(datos.getNomprog().trim());
        actual.setEstprog(datos.getEstprog());
        actual.setCodfac(datos.getCodfac());
        return repository.save(actual);
    }
}
