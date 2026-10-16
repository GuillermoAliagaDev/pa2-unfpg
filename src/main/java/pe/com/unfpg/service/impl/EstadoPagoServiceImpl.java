package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.EstadoPagoEntity;
import pe.com.unfpg.repository.EstadoPagoRepository;
import pe.com.unfpg.service.EstadoPagoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EstadoPagoServiceImpl implements EstadoPagoService {
    private final EstadoPagoRepository repository;

    public EstadoPagoServiceImpl(EstadoPagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EstadoPagoEntity> listar() {
        return repository.findAll(Sort.by("codestp"));
    }

    @Override
    public EstadoPagoEntity buscarPorId(Integer codestp) {
        if (codestp == null || codestp <= 0) throw ConsultaGetException.idInvalido("codestp");
        return repository.findById(codestp)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("estadopago"));
    }
    
    @Override
    @Transactional
    public EstadoPagoEntity actualizar(Integer codestp, EstadoPagoEntity datos) {
        if (codestp == null || codestp <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null || datos.getNomestp() == null
                || datos.getNomestp().trim().isEmpty()
                || datos.getNomestp().trim().length() > 40
                || datos.getEstestp() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos");
        }
        EstadoPagoEntity actual = repository.findById(codestp)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
        actual.setNomestp(datos.getNomestp().trim());
        actual.setEstestp(datos.getEstestp());
        return repository.save(actual);
    }
}
