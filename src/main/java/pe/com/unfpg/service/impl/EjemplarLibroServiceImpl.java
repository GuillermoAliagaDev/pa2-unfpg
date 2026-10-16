package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.EjemplarLibroEntity;
import pe.com.unfpg.entity.LibroEntity;
import pe.com.unfpg.repository.EjemplarLibroRepository;
import pe.com.unfpg.service.EjemplarLibroService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EjemplarLibroServiceImpl implements EjemplarLibroService {
    private final EjemplarLibroRepository repository;

    public EjemplarLibroServiceImpl(EjemplarLibroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EjemplarLibroEntity> listar() {
        return repository.findAll(Sort.by("codeje"));
    }

    @Override
    public EjemplarLibroEntity buscarPorId(Integer codeje) {
        if (codeje == null || codeje <= 0) throw ConsultaGetException.idInvalido("codeje");
        return repository.findById(codeje)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("ejemplarlibro"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public EjemplarLibroEntity actualizar(Integer codeje, EjemplarLibroEntity datos) {
        if (codeje == null || codeje <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getCodlib() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codlib obligatorio");
        if (datos.getCodlib() != null && datos.getCodlib() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codlib invalida");
        if (datos.getCodlib() != null && entityManager.find(LibroEntity.class, datos.getCodlib()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codlib inexistente");
        if (datos.getCodejemplar() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codejemplar obligatorio");
        if (datos.getCodejemplar().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codejemplar vacio");
        if (datos.getCodejemplar() != null && datos.getCodejemplar().length() > 50) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codejemplar demasiado largo");
        if (datos.getEstadoeje() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estadoeje obligatorio");
        if (datos.getEstadoeje().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estadoeje vacio");
        if (datos.getEstadoeje() != null && datos.getEstadoeje().length() > 30) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estadoeje demasiado largo");
        if (datos.getEsteje() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo esteje obligatorio");
        EjemplarLibroEntity actual = repository.findById(codeje).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EjemplarLibro no encontrado"));
        actual.setCodlib(datos.getCodlib());
        actual.setCodejemplar(datos.getCodejemplar().trim());
        actual.setEstadoeje(datos.getEstadoeje().trim());
        actual.setEsteje(datos.getEsteje());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public EjemplarLibroEntity deshabilitar(Integer codeje) {
        if (codeje == null || codeje <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        EjemplarLibroEntity actual = repository.findById(codeje)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EjemplarLibro no encontrado"));
        actual.setEsteje(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public EjemplarLibroEntity habilitar(Integer codeje) {
        if (codeje == null || codeje <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        EjemplarLibroEntity actual = repository.findById(codeje)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EjemplarLibro no encontrado"));
        actual.setEsteje(true);
        return repository.save(actual);
    }
}
