package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.UsuarioRolEntity;
import pe.com.unfpg.entity.UsuarioRolId;
import pe.com.unfpg.repository.UsuarioRolRepository;
import pe.com.unfpg.service.UsuarioRolService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class UsuarioRolServiceImpl implements UsuarioRolService {
    private final UsuarioRolRepository repository;

    public UsuarioRolServiceImpl(UsuarioRolRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UsuarioRolEntity> listar() {
        return repository.findAll(Sort.by("codusu", "codrol"));
    }

    @Override
    public UsuarioRolEntity buscarPorId(Integer codusu, Integer codrol) {
        if (codusu == null || codusu <= 0) throw ConsultaGetException.idInvalido("codusu");
        if (codrol == null || codrol <= 0) throw ConsultaGetException.idInvalido("codrol");
        return repository.findById(new UsuarioRolId(codusu, codrol))
            .orElseThrow(() -> ConsultaGetException.noEncontrado("usuariorol"));
    }
}
