package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.CategoriaLibroEntity;
import pe.com.unfpg.repository.CategoriaLibroRepository;
import pe.com.unfpg.service.CategoriaLibroService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class CategoriaLibroServiceImpl implements CategoriaLibroService {
    private final CategoriaLibroRepository repository;

    public CategoriaLibroServiceImpl(CategoriaLibroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoriaLibroEntity> listar() {
        return repository.findAll(Sort.by("codcatl"));
    }

    @Override
    public CategoriaLibroEntity buscarPorId(Integer codcatl) {
        if (codcatl == null || codcatl <= 0) throw ConsultaGetException.idInvalido("codcatl");
        return repository.findById(codcatl)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("categorialibro"));
    }
    @Override
    @Transactional
    public CategoriaLibroEntity actualizar(Integer codcatl, CategoriaLibroEntity datos) {
        if (codcatl == null || codcatl <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null || datos.getNomcatl() == null || datos.getNomcatl().trim().isEmpty() || datos.getNomcatl().trim().length() > 40 || datos.getEstcatl() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos");
        }
        CategoriaLibroEntity existente = repository.findById(codcatl)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CategoriaLibro no encontrado"));
        existente.setNomcatl(datos.getNomcatl().trim());
        existente.setEstcatl(datos.getEstcatl());
        return repository.save(existente);
    }
}
