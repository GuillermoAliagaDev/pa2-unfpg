package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.FacultadEntity;
import pe.com.unfpg.repository.FacultadRepository;
import pe.com.unfpg.service.FacultadService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class FacultadServiceImpl implements FacultadService {
    private final FacultadRepository repository;

    public FacultadServiceImpl(FacultadRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FacultadEntity> listar() {
        return repository.findAll(Sort.by("codfac"));
    }

    @Override
    public FacultadEntity buscarPorId(Integer codfac) {
        if (codfac == null || codfac <= 0) throw ConsultaGetException.idInvalido("codfac");
        return repository.findById(codfac)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("facultad"));
    }
    
    @Override
    @Transactional
    public FacultadEntity actualizar(Integer codfac, FacultadEntity datos) {
        if (codfac == null || codfac <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getNomfac() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomfac obligatorio");
        if (datos.getNomfac().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomfac vacio");
        if (datos.getNomfac() != null && datos.getNomfac().length() > 50) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomfac demasiado largo");
        if (datos.getDesfac() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo desfac obligatorio");
        if (datos.getDesfac().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo desfac vacio");
        if (datos.getEstfac() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estfac obligatorio");
        FacultadEntity actual = repository.findById(codfac).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Facultad no encontrado"));
        actual.setNomfac(datos.getNomfac().trim());
        actual.setDesfac(datos.getDesfac().trim());
        actual.setEstfac(datos.getEstfac());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public FacultadEntity deshabilitar(Integer codfac) {
        if (codfac == null || codfac <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        FacultadEntity actual = repository.findById(codfac)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Facultad no encontrado"));
        actual.setEstfac(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public FacultadEntity habilitar(Integer codfac) {
        if (codfac == null || codfac <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        FacultadEntity actual = repository.findById(codfac)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Facultad no encontrado"));
        actual.setEstfac(true);
        return repository.save(actual);
    }
}
