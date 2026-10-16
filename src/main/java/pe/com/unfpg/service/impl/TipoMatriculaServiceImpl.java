package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.TipoMatriculaEntity;
import pe.com.unfpg.repository.TipoMatriculaRepository;
import pe.com.unfpg.service.TipoMatriculaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class TipoMatriculaServiceImpl implements TipoMatriculaService {
    private final TipoMatriculaRepository repository;

    public TipoMatriculaServiceImpl(TipoMatriculaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TipoMatriculaEntity> listar() {
        return repository.findAll(Sort.by("codtipm"));
    }

    @Override
    public TipoMatriculaEntity buscarPorId(Integer codtipm) {
        if (codtipm == null || codtipm <= 0) throw ConsultaGetException.idInvalido("codtipm");
        return repository.findById(codtipm)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("tipomatricula"));
    }
    
    @Override
    @Transactional
    public TipoMatriculaEntity actualizar(Integer codtipm, TipoMatriculaEntity datos) {
        if (codtipm == null || codtipm <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null ||
                    datos.getNomtipm() == null ||
                    datos.getNomtipm().trim().isEmpty() ||
                    datos.getNomtipm().trim().length() > 40 ||
                    datos.getEsttipm() == null ||
                    datos.getDestipm() == null ||
                    datos.getDestipm().trim().isEmpty() ||
                    datos.getDestipm().trim().length() > 300) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos para TipoMatricula");
        }
        TipoMatriculaEntity actual = repository.findById(codtipm)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TipoMatricula no encontrado"));
        actual.setNomtipm(datos.getNomtipm().trim());
            actual.setEsttipm(datos.getEsttipm());
            actual.setDestipm(datos.getDestipm().trim());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public TipoMatriculaEntity deshabilitar(Integer codtipm) {
        if (codtipm == null || codtipm <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        TipoMatriculaEntity actual = repository.findById(codtipm)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TipoMatricula no encontrado"));
        actual.setEsttipm(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public TipoMatriculaEntity habilitar(Integer codtipm) {
        if (codtipm == null || codtipm <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        TipoMatriculaEntity actual = repository.findById(codtipm)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TipoMatricula no encontrado"));
        actual.setEsttipm(true);
        return repository.save(actual);
    }
}
