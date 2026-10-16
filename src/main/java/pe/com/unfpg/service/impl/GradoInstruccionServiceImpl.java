package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.GradoInstruccionEntity;
import pe.com.unfpg.repository.GradoInstruccionRepository;
import pe.com.unfpg.service.GradoInstruccionService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class GradoInstruccionServiceImpl implements GradoInstruccionService {
    private final GradoInstruccionRepository repository;

    public GradoInstruccionServiceImpl(GradoInstruccionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GradoInstruccionEntity> listar() {
        return repository.findAll(Sort.by("codgrai"));
    }

    @Override
    public GradoInstruccionEntity buscarPorId(Integer codgrai) {
        if (codgrai == null || codgrai <= 0) throw ConsultaGetException.idInvalido("codgrai");
        return repository.findById(codgrai)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("gradoinstruccion"));
    }
    
    @Override
    @Transactional
    public GradoInstruccionEntity actualizar(Integer codgrai, GradoInstruccionEntity datos) {
        if (codgrai == null || codgrai <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null || datos.getNomgrai() == null ||
                datos.getNomgrai().trim().isEmpty() ||
                datos.getNomgrai().trim().length() > 50 ||
                datos.getEstgrai() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos");
        }
        GradoInstruccionEntity existente = repository.findById(codgrai).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
        existente.setNomgrai(datos.getNomgrai().trim());
        existente.setEstgrai(datos.getEstgrai());
        return repository.save(existente);
    }

    @Override
    @Transactional
    public GradoInstruccionEntity deshabilitar(Integer codgrai) {
        if (codgrai == null || codgrai <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        GradoInstruccionEntity actual = repository.findById(codgrai)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "GradoInstruccion no encontrado"));
        actual.setEstgrai(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public GradoInstruccionEntity habilitar(Integer codgrai) {
        if (codgrai == null || codgrai <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        GradoInstruccionEntity actual = repository.findById(codgrai)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "GradoInstruccion no encontrado"));
        actual.setEstgrai(true);
        return repository.save(actual);
    }
}
