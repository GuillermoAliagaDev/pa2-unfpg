package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.CategoriaLibroEntity;
import pe.com.unfpg.entity.EditorialEntity;
import pe.com.unfpg.entity.LibroEntity;
import pe.com.unfpg.repository.LibroRepository;
import pe.com.unfpg.service.LibroService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class LibroServiceImpl implements LibroService {
    private final LibroRepository repository;

    public LibroServiceImpl(LibroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LibroEntity> listar() {
        return repository.findAll(Sort.by("codlib"));
    }

    @Override
    public LibroEntity buscarPorId(Integer codlib) {
        if (codlib == null || codlib <= 0) throw ConsultaGetException.idInvalido("codlib");
        return repository.findById(codlib)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("libro"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public LibroEntity actualizar(Integer codlib, LibroEntity datos) {
        if (codlib == null || codlib <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getIsbnlib() != null && datos.getIsbnlib().length() > 20) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo isbnlib demasiado largo");
        if (datos.getTitlib() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo titlib obligatorio");
        if (datos.getTitlib().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo titlib vacio");
        if (datos.getTitlib() != null && datos.getTitlib().length() > 200) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo titlib demasiado largo");
        if (datos.getAutlib() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo autlib obligatorio");
        if (datos.getAutlib().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo autlib vacio");
        if (datos.getAutlib() != null && datos.getAutlib().length() > 150) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo autlib demasiado largo");
        if (datos.getDeslib() != null && datos.getDeslib().length() > 300) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo deslib demasiado largo");
        if (datos.getEstlib() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estlib obligatorio");
        if (datos.getCodcatl() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codcatl obligatorio");
        if (datos.getCodcatl() != null && datos.getCodcatl() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codcatl invalida");
        if (datos.getCodcatl() != null && entityManager.find(CategoriaLibroEntity.class, datos.getCodcatl()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codcatl inexistente");
        if (datos.getCodedi() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codedi obligatorio");
        if (datos.getCodedi() != null && datos.getCodedi() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codedi invalida");
        if (datos.getCodedi() != null && entityManager.find(EditorialEntity.class, datos.getCodedi()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codedi inexistente");
        LibroEntity actual = repository.findById(codlib).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado"));
        actual.setIsbnlib((datos.getIsbnlib() == null ? null : datos.getIsbnlib().trim()));
        actual.setTitlib(datos.getTitlib().trim());
        actual.setAutlib(datos.getAutlib().trim());
        actual.setDeslib((datos.getDeslib() == null ? null : datos.getDeslib().trim()));
        actual.setEstlib(datos.getEstlib());
        actual.setCodcatl(datos.getCodcatl());
        actual.setCodedi(datos.getCodedi());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public LibroEntity deshabilitar(Integer codlib) {
        if (codlib == null || codlib <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        LibroEntity actual = repository.findById(codlib)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado"));
        actual.setEstlib(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public LibroEntity habilitar(Integer codlib) {
        if (codlib == null || codlib <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        LibroEntity actual = repository.findById(codlib)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado"));
        actual.setEstlib(true);
        return repository.save(actual);
    }
}
