package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.RolLmsEntity;
import pe.com.unfpg.repository.RolLmsRepository;
import pe.com.unfpg.service.RolLmsService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class RolLmsServiceImpl implements RolLmsService {
    private final RolLmsRepository repository;

    public RolLmsServiceImpl(RolLmsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RolLmsEntity> listar() {
        return repository.findAll(Sort.by("codroll"));
    }

    @Override
    public RolLmsEntity buscarPorId(Integer codroll) {
        if (codroll == null || codroll <= 0) throw ConsultaGetException.idInvalido("codroll");
        return repository.findById(codroll)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("rollms"));
    }
    
    @Override
    @Transactional
    public RolLmsEntity actualizar(Integer codroll, RolLmsEntity datos) {
        if (codroll == null || codroll <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null || datos.getNomroll() == null ||
                datos.getNomroll().trim().isEmpty() ||
                datos.getNomroll().trim().length() > 40 ||
                datos.getEstroll() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos");
        }
        RolLmsEntity existente = repository.findById(codroll).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
        existente.setNomroll(datos.getNomroll().trim());
        existente.setEstroll(datos.getEstroll());
        return repository.save(existente);
    }

    @Override
    @Transactional
    public RolLmsEntity deshabilitar(Integer codroll) {
        if (codroll == null || codroll <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        RolLmsEntity actual = repository.findById(codroll)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "RolLms no encontrado"));
        actual.setEstroll(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public RolLmsEntity habilitar(Integer codroll) {
        if (codroll == null || codroll <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        RolLmsEntity actual = repository.findById(codroll)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "RolLms no encontrado"));
        actual.setEstroll(true);
        return repository.save(actual);
    }
}
