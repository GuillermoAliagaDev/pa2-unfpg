package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.EstadoCivilEntity;
import pe.com.unfpg.repository.EstadoCivilRepository;
import pe.com.unfpg.service.EstadoCivilService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EstadoCivilServiceImpl implements EstadoCivilService {
    private final EstadoCivilRepository repository;

    public EstadoCivilServiceImpl(EstadoCivilRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EstadoCivilEntity> listar() {
        return repository.findAll(Sort.by("codestc"));
    }

    @Override
    public EstadoCivilEntity buscarPorId(Integer codestc) {
        if (codestc == null || codestc <= 0) throw ConsultaGetException.idInvalido("codestc");
        return repository.findById(codestc)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("estadocivil"));
    }
    
    @Override
    @Transactional
    public EstadoCivilEntity actualizar(Integer codestc, EstadoCivilEntity datos) {
        if (codestc == null || codestc <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null || datos.getNomestc() == null
                || datos.getNomestc().trim().isEmpty()
                || datos.getNomestc().trim().length() > 50
                || datos.getEstestc() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos");
        }
        EstadoCivilEntity actual = repository.findById(codestc)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
        actual.setNomestc(datos.getNomestc().trim());
        actual.setEstestc(datos.getEstestc());
        return repository.save(actual);
    }
}
