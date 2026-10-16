package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.TipoCalificacionEntity;
import pe.com.unfpg.repository.TipoCalificacionRepository;
import pe.com.unfpg.service.TipoCalificacionService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class TipoCalificacionServiceImpl implements TipoCalificacionService {
    private final TipoCalificacionRepository repository;

    public TipoCalificacionServiceImpl(TipoCalificacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TipoCalificacionEntity> listar() {
        return repository.findAll(Sort.by("codtipc"));
    }

    @Override
    public TipoCalificacionEntity buscarPorId(Integer codtipc) {
        if (codtipc == null || codtipc <= 0) throw ConsultaGetException.idInvalido("codtipc");
        return repository.findById(codtipc)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("tipocalificacion"));
    }
    
    @Override
    @Transactional
    public TipoCalificacionEntity actualizar(Integer codtipc, TipoCalificacionEntity datos) {
        if (codtipc == null || codtipc <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null ||
                    datos.getNomtipc() == null ||
                    datos.getNomtipc().trim().isEmpty() ||
                    datos.getNomtipc().trim().length() > 50 ||
                    datos.getEsttipc() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos para TipoCalificacion");
        }
        TipoCalificacionEntity actual = repository.findById(codtipc)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TipoCalificacion no encontrado"));
        actual.setNomtipc(datos.getNomtipc().trim());
            actual.setEsttipc(datos.getEsttipc());
        return repository.save(actual);
    }
}
