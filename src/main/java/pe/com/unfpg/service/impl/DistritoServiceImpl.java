package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.DistritoEntity;
import pe.com.unfpg.repository.DistritoRepository;
import pe.com.unfpg.service.DistritoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class DistritoServiceImpl implements DistritoService {
    private final DistritoRepository repository;

    public DistritoServiceImpl(DistritoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DistritoEntity> listar() {
        return repository.findAll(Sort.by("coddis"));
    }

    @Override
    public DistritoEntity buscarPorId(Integer coddis) {
        if (coddis == null || coddis <= 0) throw ConsultaGetException.idInvalido("coddis");
        return repository.findById(coddis)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("distrito"));
    }
    @Override
    @Transactional
    public DistritoEntity actualizar(Integer coddis, DistritoEntity datos) {
        if (coddis == null || coddis <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null || datos.getNomdis() == null || datos.getNomdis().trim().isEmpty() || datos.getNomdis().trim().length() > 50 || datos.getEstdis() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos");
        }
        DistritoEntity existente = repository.findById(coddis)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Distrito no encontrado"));
        existente.setNomdis(datos.getNomdis().trim());
        existente.setEstdis(datos.getEstdis());
        return repository.save(existente);
    }

    @Override
    @Transactional
    public DistritoEntity deshabilitar(Integer coddis) {
        if (coddis == null || coddis <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        DistritoEntity actual = repository.findById(coddis)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Distrito no encontrado"));
        actual.setEstdis(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public DistritoEntity habilitar(Integer coddis) {
        if (coddis == null || coddis <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        DistritoEntity actual = repository.findById(coddis)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Distrito no encontrado"));
        actual.setEstdis(true);
        return repository.save(actual);
    }
}
