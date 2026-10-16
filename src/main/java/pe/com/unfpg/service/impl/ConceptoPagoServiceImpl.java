package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;
import pe.com.unfpg.entity.ConceptoPagoEntity;
import pe.com.unfpg.repository.ConceptoPagoRepository;
import pe.com.unfpg.service.ConceptoPagoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class ConceptoPagoServiceImpl implements ConceptoPagoService {
    private final ConceptoPagoRepository repository;

    public ConceptoPagoServiceImpl(ConceptoPagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ConceptoPagoEntity> listar() {
        return repository.findAll(Sort.by("codconp"));
    }

    @Override
    public ConceptoPagoEntity buscarPorId(Integer codconp) {
        if (codconp == null || codconp <= 0) throw ConsultaGetException.idInvalido("codconp");
        return repository.findById(codconp)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("conceptopago"));
    }
    @Override
    @Transactional
    public ConceptoPagoEntity actualizar(Integer codconp, ConceptoPagoEntity datos) {
        if (codconp == null || codconp <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null || datos.getNomconp() == null || datos.getNomconp().trim().isEmpty() || datos.getNomconp().trim().length() > 100 || datos.getEstconp() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos");
        }
        ConceptoPagoEntity existente = repository.findById(codconp)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ConceptoPago no encontrado"));
        existente.setNomconp(datos.getNomconp().trim());
        existente.setEstconp(datos.getEstconp());
        existente.setDesconp(datos.getDesconp());
        return repository.save(existente);
    }

    @Override
    @Transactional
    public ConceptoPagoEntity deshabilitar(Integer codconp) {
        if (codconp == null || codconp <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        ConceptoPagoEntity actual = repository.findById(codconp)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ConceptoPago no encontrado"));
        actual.setEstconp(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public ConceptoPagoEntity habilitar(Integer codconp) {
        if (codconp == null || codconp <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        ConceptoPagoEntity actual = repository.findById(codconp)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ConceptoPago no encontrado"));
        actual.setEstconp(true);
        return repository.save(actual);
    }
}
