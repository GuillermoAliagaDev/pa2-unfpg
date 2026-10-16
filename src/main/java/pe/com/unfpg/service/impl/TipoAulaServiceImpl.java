package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.TipoAulaEntity;
import pe.com.unfpg.repository.TipoAulaRepository;
import pe.com.unfpg.service.TipoAulaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class TipoAulaServiceImpl implements TipoAulaService {
    private final TipoAulaRepository repository;

    public TipoAulaServiceImpl(TipoAulaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TipoAulaEntity> listar() {
        return repository.findAll(Sort.by("codtipa"));
    }

    @Override
    public TipoAulaEntity buscarPorId(Integer codtipa) {
        if (codtipa == null || codtipa <= 0) throw ConsultaGetException.idInvalido("codtipa");
        return repository.findById(codtipa)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("tipoaula"));
    }
    
    @Override
    @Transactional
    public TipoAulaEntity actualizar(Integer codtipa, TipoAulaEntity datos) {
        if (codtipa == null || codtipa <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null ||
                    datos.getNomtipa() == null ||
                    datos.getNomtipa().trim().isEmpty() ||
                    datos.getNomtipa().trim().length() > 50 ||
                    datos.getEsttipa() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos para TipoAula");
        }
        TipoAulaEntity actual = repository.findById(codtipa)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TipoAula no encontrado"));
        actual.setNomtipa(datos.getNomtipa().trim());
            actual.setEsttipa(datos.getEsttipa());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public TipoAulaEntity deshabilitar(Integer codtipa) {
        if (codtipa == null || codtipa <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        TipoAulaEntity actual = repository.findById(codtipa)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TipoAula no encontrado"));
        actual.setEsttipa(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public TipoAulaEntity habilitar(Integer codtipa) {
        if (codtipa == null || codtipa <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        TipoAulaEntity actual = repository.findById(codtipa)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TipoAula no encontrado"));
        actual.setEsttipa(true);
        return repository.save(actual);
    }
}
