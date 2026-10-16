package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.MetodoPagoEntity;
import pe.com.unfpg.repository.MetodoPagoRepository;
import pe.com.unfpg.service.MetodoPagoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class MetodoPagoServiceImpl implements MetodoPagoService {
    private final MetodoPagoRepository repository;

    public MetodoPagoServiceImpl(MetodoPagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MetodoPagoEntity> listar() {
        return repository.findAll(Sort.by("codmetp"));
    }

    @Override
    public MetodoPagoEntity buscarPorId(Integer codmetp) {
        if (codmetp == null || codmetp <= 0) throw ConsultaGetException.idInvalido("codmetp");
        return repository.findById(codmetp)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("metodopago"));
    }
    
    @Override
    @Transactional
    public MetodoPagoEntity actualizar(Integer codmetp, MetodoPagoEntity datos) {
        if (codmetp == null || codmetp <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null || datos.getNommetp() == null ||
                datos.getNommetp().trim().isEmpty() ||
                datos.getNommetp().trim().length() > 40 ||
                datos.getEstmetp() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos");
        }
        MetodoPagoEntity existente = repository.findById(codmetp).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
        existente.setNommetp(datos.getNommetp().trim());
        existente.setEstmetp(datos.getEstmetp());
        return repository.save(existente);
    }
}
