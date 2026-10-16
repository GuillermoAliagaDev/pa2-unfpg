package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.EditorialEntity;
import pe.com.unfpg.repository.EditorialRepository;
import pe.com.unfpg.service.EditorialService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EditorialServiceImpl implements EditorialService {
    private final EditorialRepository repository;

    public EditorialServiceImpl(EditorialRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EditorialEntity> listar() {
        return repository.findAll(Sort.by("codedi"));
    }

    @Override
    public EditorialEntity buscarPorId(Integer codedi) {
        if (codedi == null || codedi <= 0) throw ConsultaGetException.idInvalido("codedi");
        return repository.findById(codedi)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("editorial"));
    }
    
    @Override
    @Transactional
    public EditorialEntity actualizar(Integer codedi, EditorialEntity datos) {
        if (codedi == null || codedi <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getNomedi() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomedi obligatorio");
        if (datos.getNomedi().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomedi vacio");
        if (datos.getNomedi() != null && datos.getNomedi().length() > 100) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomedi demasiado largo");
        if (datos.getEstedi() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estedi obligatorio");
        EditorialEntity actual = repository.findById(codedi).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Editorial no encontrado"));
        actual.setNomedi(datos.getNomedi().trim());
        actual.setEstedi(datos.getEstedi());
        return repository.save(actual);
    }
}
