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
import pe.com.unfpg.entity.EjemplarLibroEntity;
import pe.com.unfpg.entity.EstadoPrestamoLibroEntity;
import pe.com.unfpg.entity.PrestamoLibroEntity;
import pe.com.unfpg.repository.PrestamoLibroRepository;
import pe.com.unfpg.service.PrestamoLibroService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class PrestamoLibroServiceImpl implements PrestamoLibroService {
    private final PrestamoLibroRepository repository;

    public PrestamoLibroServiceImpl(PrestamoLibroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PrestamoLibroEntity> listar() {
        return repository.findAll(Sort.by("numpre"));
    }

    @Override
    public PrestamoLibroEntity buscarPorId(Integer numpre) {
        if (numpre == null || numpre <= 0) throw ConsultaGetException.idInvalido("numpre");
        return repository.findById(numpre)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("prestamolibro"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public PrestamoLibroEntity actualizar(Integer numpre, PrestamoLibroEntity datos) {
        if (numpre == null || numpre <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getDevpre() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo devpre obligatorio");
        if (datos.getEstpre() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estpre obligatorio");
        if (datos.getCodalu() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codalu obligatorio");
        if (datos.getCodalu() != null && datos.getCodalu() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codalu invalida");
        if (datos.getCodalu() != null && entityManager.find(AlumnoEntity.class, datos.getCodalu()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codalu inexistente");
        if (datos.getCodeje() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codeje obligatorio");
        if (datos.getCodeje() != null && datos.getCodeje() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codeje invalida");
        if (datos.getCodeje() != null && entityManager.find(EjemplarLibroEntity.class, datos.getCodeje()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codeje inexistente");
        if (datos.getCodestl() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codestl obligatorio");
        if (datos.getCodestl() != null && datos.getCodestl() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codestl invalida");
        if (datos.getCodestl() != null && entityManager.find(EstadoPrestamoLibroEntity.class, datos.getCodestl()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codestl inexistente");
        PrestamoLibroEntity actual = repository.findById(numpre).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PrestamoLibro no encontrado"));
        actual.setFecdpre(datos.getFecdpre());
        actual.setDevpre(datos.getDevpre());
        actual.setEstpre(datos.getEstpre());
        actual.setCodalu(datos.getCodalu());
        actual.setCodeje(datos.getCodeje());
        actual.setCodestl(datos.getCodestl());
        return repository.save(actual);
    }
}
