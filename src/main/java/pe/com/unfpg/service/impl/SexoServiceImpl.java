package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.SexoEntity;
import pe.com.unfpg.repository.SexoRepository;
import pe.com.unfpg.service.SexoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class SexoServiceImpl implements SexoService {
    private final SexoRepository repository;

    public SexoServiceImpl(SexoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SexoEntity> listar() {
        return repository.findAll(Sort.by("codsex"));
    }

    @Override
    public SexoEntity buscarPorId(Integer codsex) {
        if (codsex == null || codsex <= 0) throw ConsultaGetException.idInvalido("codsex");
        return repository.findById(codsex)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("sexo"));
    }
    
    @Override
    @Transactional
    public SexoEntity actualizar(Integer codsex, SexoEntity datos) {
        if (codsex == null || codsex <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null || datos.getNomsex() == null ||
                datos.getNomsex().trim().isEmpty() ||
                datos.getNomsex().trim().length() > 30 ||
                datos.getEstsex() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos");
        }
        SexoEntity existente = repository.findById(codsex).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
        existente.setNomsex(datos.getNomsex().trim());
        existente.setEstsex(datos.getEstsex());
        return repository.save(existente);
    }

    @Override
    @Transactional
    public SexoEntity deshabilitar(Integer codsex) {
        if (codsex == null || codsex <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        SexoEntity actual = repository.findById(codsex)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sexo no encontrado"));
        actual.setEstsex(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public SexoEntity habilitar(Integer codsex) {
        if (codsex == null || codsex <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        SexoEntity actual = repository.findById(codsex)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sexo no encontrado"));
        actual.setEstsex(true);
        return repository.save(actual);
    }
}
