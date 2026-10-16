package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.OrdenPagoEntity;
import pe.com.unfpg.entity.PagoEntity;
import pe.com.unfpg.repository.PagoRepository;
import pe.com.unfpg.service.PagoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class PagoServiceImpl implements PagoService {
    private final PagoRepository repository;

    public PagoServiceImpl(PagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PagoEntity> listar() {
        return repository.findAll(Sort.by("codpag"));
    }

    @Override
    public PagoEntity buscarPorId(Integer codpag) {
        if (codpag == null || codpag <= 0) throw ConsultaGetException.idInvalido("codpag");
        return repository.findById(codpag)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("pago"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public PagoEntity actualizar(Integer codpag, PagoEntity datos) {
        if (codpag == null || codpag <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getMontopag() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo montopag obligatorio");
        if (datos.getEstpag() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estpag obligatorio");
        if (datos.getCodordpag() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codordpag obligatorio");
        if (datos.getCodordpag() != null && datos.getCodordpag() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codordpag invalida");
        if (datos.getCodordpag() != null && entityManager.find(OrdenPagoEntity.class, datos.getCodordpag()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codordpag inexistente");
        PagoEntity actual = repository.findById(codpag).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pago no encontrado"));
        actual.setMontopag(datos.getMontopag());
        actual.setEstpag(datos.getEstpag());
        actual.setCodordpag(datos.getCodordpag());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public PagoEntity deshabilitar(Integer codpag) {
        if (codpag == null || codpag <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        PagoEntity actual = repository.findById(codpag)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pago no encontrado"));
        actual.setEstpag(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public PagoEntity habilitar(Integer codpag) {
        if (codpag == null || codpag <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        PagoEntity actual = repository.findById(codpag)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pago no encontrado"));
        actual.setEstpag(true);
        return repository.save(actual);
    }
}
