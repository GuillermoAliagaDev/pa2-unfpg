package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.UsuarioEntity;
import pe.com.unfpg.repository.UsuarioRepository;
import pe.com.unfpg.service.UsuarioService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UsuarioEntity> listar() {
        return repository.findAll(Sort.by("codusu"));
    }

    @Override
    public UsuarioEntity buscarPorId(Integer codusu) {
        if (codusu == null || codusu <= 0) throw ConsultaGetException.idInvalido("codusu");
        return repository.findById(codusu)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("usuario"));
    }
}
