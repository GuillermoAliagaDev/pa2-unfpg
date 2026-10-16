package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.UbicacionEntity;
import pe.com.unfpg.repository.UbicacionRepository;
import pe.com.unfpg.service.UbicacionService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class UbicacionServiceImpl implements UbicacionService {
    private final UbicacionRepository repository;

    public UbicacionServiceImpl(UbicacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UbicacionEntity> listar() {
        return repository.findAll(Sort.by("codubi"));
    }

    @Override
    public UbicacionEntity buscarPorId(Integer codubi) {
        if (codubi == null || codubi <= 0) throw ConsultaGetException.idInvalido("codubi");
        return repository.findById(codubi)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("ubicacion"));
    }
    
    @Override
    @Transactional
    public UbicacionEntity actualizar(Integer codubi, UbicacionEntity datos) {
        if (codubi == null || codubi <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null ||
                    datos.getNomubi() == null ||
                    datos.getNomubi().trim().isEmpty() ||
                    datos.getNomubi().trim().length() > 100 ||
                    datos.getEstubi() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos para Ubicacion");
        }
        UbicacionEntity actual = repository.findById(codubi)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ubicacion no encontrado"));
        actual.setNomubi(datos.getNomubi().trim());
            actual.setEstubi(datos.getEstubi());
            actual.setDesubi(datos.getDesubi());
        return repository.save(actual);
    }
}
