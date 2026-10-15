package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
}
