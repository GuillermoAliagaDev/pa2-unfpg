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
import pe.com.unfpg.entity.ProgramaEntity;
import pe.com.unfpg.repository.CursoRepository;
import pe.com.unfpg.service.CursoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class CursoServiceImpl implements CursoService {
    private final CursoRepository repository;

    public CursoServiceImpl(CursoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CursoEntity> listar() {
        return repository.findAll(Sort.by("codcur"));
    }

    @Override
    public CursoEntity buscarPorId(Integer codcur) {
        if (codcur == null || codcur <= 0) throw ConsultaGetException.idInvalido("codcur");
        return repository.findById(codcur)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("curso"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public CursoEntity actualizar(Integer codcur, CursoEntity datos) {
        if (codcur == null || codcur <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getSercur() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo sercur obligatorio");
        if (datos.getSercur().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo sercur vacio");
        if (datos.getSercur() != null && datos.getSercur().length() > 20) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo sercur demasiado largo");
        if (datos.getNomcur() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomcur obligatorio");
        if (datos.getNomcur().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomcur vacio");
        if (datos.getNomcur() != null && datos.getNomcur().length() > 150) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomcur demasiado largo");
        if (datos.getBlocur() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo blocur obligatorio");
        if (datos.getBlocur() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo blocur invalido");
        if (datos.getCodprog() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codprog obligatorio");
        if (datos.getCodprog() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codprog invalido");
        if (datos.getCodprog() != null && entityManager.find(ProgramaEntity.class, datos.getCodprog()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codprog inexistente");
        CursoEntity actual = repository.findById(codcur).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado"));
        actual.setSercur(datos.getSercur().trim());
        actual.setNomcur(datos.getNomcur().trim());
        actual.setBlocur(datos.getBlocur());
        actual.setCodprog(datos.getCodprog());
        return repository.save(actual);
    }
}
