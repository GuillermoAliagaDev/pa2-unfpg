package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.TipoDocumentoEntity;
import pe.com.unfpg.repository.TipoDocumentoRepository;
import pe.com.unfpg.service.TipoDocumentoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
    private final TipoDocumentoRepository repository;

    public TipoDocumentoServiceImpl(TipoDocumentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TipoDocumentoEntity> listar() {
        return repository.findAll(Sort.by("codtipd"));
    }

    @Override
    public TipoDocumentoEntity buscarPorId(Integer codtipd) {
        if (codtipd == null || codtipd <= 0) throw ConsultaGetException.idInvalido("codtipd");
        return repository.findById(codtipd)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("tipodocumento"));
    }
    
    @Override
    @Transactional
    public TipoDocumentoEntity actualizar(Integer codtipd, TipoDocumentoEntity datos) {
        if (codtipd == null || codtipd <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null ||
                    datos.getNomtipd() == null ||
                    datos.getNomtipd().trim().isEmpty() ||
                    datos.getNomtipd().trim().length() > 30 ||
                    datos.getEsttipd() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos para TipoDocumento");
        }
        TipoDocumentoEntity actual = repository.findById(codtipd)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TipoDocumento no encontrado"));
        actual.setNomtipd(datos.getNomtipd().trim());
            actual.setEsttipd(datos.getEsttipd());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public TipoDocumentoEntity deshabilitar(Integer codtipd) {
        if (codtipd == null || codtipd <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        TipoDocumentoEntity actual = repository.findById(codtipd)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TipoDocumento no encontrado"));
        actual.setEsttipd(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public TipoDocumentoEntity habilitar(Integer codtipd) {
        if (codtipd == null || codtipd <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        TipoDocumentoEntity actual = repository.findById(codtipd)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TipoDocumento no encontrado"));
        actual.setEsttipd(true);
        return repository.save(actual);
    }
}
