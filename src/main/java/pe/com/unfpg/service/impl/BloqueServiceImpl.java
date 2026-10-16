package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.BloqueEntity;
import pe.com.unfpg.repository.BloqueRepository;
import pe.com.unfpg.service.BloqueService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class BloqueServiceImpl implements BloqueService {
    private final BloqueRepository repository;

    public BloqueServiceImpl(BloqueRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BloqueEntity> listar() {
        return repository.findAll(Sort.by("codblo"));
    }

    @Override
    public BloqueEntity buscarPorId(Integer codblo) {
        if (codblo == null || codblo <= 0) throw ConsultaGetException.idInvalido("codblo");
        return repository.findById(codblo)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("bloque"));
    }
    
    @Override
    @Transactional
    public BloqueEntity actualizar(Integer codblo, BloqueEntity datos) {
        if (codblo == null || codblo <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getNomblo() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomblo obligatorio");
        if (datos.getNomblo().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomblo vacio");
        if (datos.getNomblo() != null && datos.getNomblo().length() > 20) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomblo demasiado largo");
        if (datos.getIniblo() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo iniblo obligatorio");
        if (datos.getFinblo() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo finblo obligatorio");
        if (datos.getEstblo() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estblo obligatorio");
        BloqueEntity actual = repository.findById(codblo).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bloque no encontrado"));
        actual.setNomblo(datos.getNomblo().trim());
        actual.setIniblo(datos.getIniblo());
        actual.setFinblo(datos.getFinblo());
        actual.setEstblo(datos.getEstblo());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public BloqueEntity deshabilitar(Integer codblo) {
        if (codblo == null || codblo <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        BloqueEntity actual = repository.findById(codblo)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bloque no encontrado"));
        actual.setEstblo(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public BloqueEntity habilitar(Integer codblo) {
        if (codblo == null || codblo <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        BloqueEntity actual = repository.findById(codblo)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bloque no encontrado"));
        actual.setEstblo(true);
        return repository.save(actual);
    }
}
