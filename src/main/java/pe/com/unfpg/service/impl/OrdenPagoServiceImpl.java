package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.ConceptoPagoEntity;
import pe.com.unfpg.entity.EstadoPagoEntity;
import pe.com.unfpg.entity.MatriculaEntity;
import pe.com.unfpg.entity.MetodoPagoEntity;
import pe.com.unfpg.entity.OrdenPagoEntity;
import pe.com.unfpg.repository.OrdenPagoRepository;
import pe.com.unfpg.service.OrdenPagoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class OrdenPagoServiceImpl implements OrdenPagoService {
    private final OrdenPagoRepository repository;

    public OrdenPagoServiceImpl(OrdenPagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OrdenPagoEntity> listar() {
        return repository.findAll(Sort.by("codordpag"));
    }

    @Override
    public OrdenPagoEntity buscarPorId(Integer codordpag) {
        if (codordpag == null || codordpag <= 0) throw ConsultaGetException.idInvalido("codordpag");
        return repository.findById(codordpag)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("ordenpago"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public OrdenPagoEntity actualizar(Integer codordpag, OrdenPagoEntity datos) {
        if (codordpag == null || codordpag <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getMonto() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo monto obligatorio");
        if (datos.getEstordpag() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estordpag obligatorio");
        if (datos.getNummat() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nummat obligatorio");
        if (datos.getNummat() != null && datos.getNummat() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia nummat invalida");
        if (datos.getNummat() != null && entityManager.find(MatriculaEntity.class, datos.getNummat()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia nummat inexistente");
        if (datos.getCodconp() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codconp obligatorio");
        if (datos.getCodconp() != null && datos.getCodconp() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codconp invalida");
        if (datos.getCodconp() != null && entityManager.find(ConceptoPagoEntity.class, datos.getCodconp()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codconp inexistente");
        if (datos.getCodmetp() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codmetp obligatorio");
        if (datos.getCodmetp() != null && datos.getCodmetp() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codmetp invalida");
        if (datos.getCodmetp() != null && entityManager.find(MetodoPagoEntity.class, datos.getCodmetp()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codmetp inexistente");
        if (datos.getCodestp() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codestp obligatorio");
        if (datos.getCodestp() != null && datos.getCodestp() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codestp invalida");
        if (datos.getCodestp() != null && entityManager.find(EstadoPagoEntity.class, datos.getCodestp()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codestp inexistente");
        OrdenPagoEntity actual = repository.findById(codordpag).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "OrdenPago no encontrado"));
        actual.setMonto(datos.getMonto());
        actual.setEstordpag(datos.getEstordpag());
        actual.setNummat(datos.getNummat());
        actual.setCodconp(datos.getCodconp());
        actual.setCodmetp(datos.getCodmetp());
        actual.setCodestp(datos.getCodestp());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public OrdenPagoEntity deshabilitar(Integer codordpag) {
        if (codordpag == null || codordpag <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        OrdenPagoEntity actual = repository.findById(codordpag)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "OrdenPago no encontrado"));
        actual.setEstordpag(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public OrdenPagoEntity habilitar(Integer codordpag) {
        if (codordpag == null || codordpag <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        OrdenPagoEntity actual = repository.findById(codordpag)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "OrdenPago no encontrado"));
        actual.setEstordpag(true);
        return repository.save(actual);
    }
}
