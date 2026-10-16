package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.DiaSemanaEntity;
import pe.com.unfpg.repository.DiaSemanaRepository;
import pe.com.unfpg.service.DiaSemanaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class DiaSemanaServiceImpl implements DiaSemanaService {
    private final DiaSemanaRepository repository;

    public DiaSemanaServiceImpl(DiaSemanaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DiaSemanaEntity> listar() {
        return repository.findAll(Sort.by("coddias"));
    }

    @Override
    public DiaSemanaEntity buscarPorId(Integer coddias) {
        if (coddias == null || coddias <= 0) throw ConsultaGetException.idInvalido("coddias");
        return repository.findById(coddias)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("diasemana"));
    }
    @Override
    @Transactional
    public DiaSemanaEntity actualizar(Integer coddias, DiaSemanaEntity datos) {
        if (coddias == null || coddias <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null || datos.getNomdias() == null || datos.getNomdias().trim().isEmpty() || datos.getNomdias().trim().length() > 20 || datos.getEstdias() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos");
        }
        DiaSemanaEntity existente = repository.findById(coddias)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "DiaSemana no encontrado"));
        existente.setNomdias(datos.getNomdias().trim());
        existente.setEstdias(datos.getEstdias());
        return repository.save(existente);
    }

    @Override
    @Transactional
    public DiaSemanaEntity deshabilitar(Integer coddias) {
        if (coddias == null || coddias <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        DiaSemanaEntity actual = repository.findById(coddias)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "DiaSemana no encontrado"));
        actual.setEstdias(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public DiaSemanaEntity habilitar(Integer coddias) {
        if (coddias == null || coddias <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        DiaSemanaEntity actual = repository.findById(coddias)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "DiaSemana no encontrado"));
        actual.setEstdias(true);
        return repository.save(actual);
    }
}
