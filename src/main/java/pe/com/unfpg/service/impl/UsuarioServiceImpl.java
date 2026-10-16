package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.AlumnoEntity;
import pe.com.unfpg.entity.DocenteEntity;
import pe.com.unfpg.entity.EmpleadoEntity;
import pe.com.unfpg.entity.UsuarioEntity;
import pe.com.unfpg.repository.UsuarioRepository;
import pe.com.unfpg.service.UsuarioService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UsuarioEntity> listar() {
        return repository.findAll(Sort.by("codusu"));
    }

    @Override
    public UsuarioEntity buscarPorId(Integer codusu) {
        if (codusu == null || codusu <= 0) throw ConsultaGetException.idInvalido("codusu");
        return repository.findById(codusu)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("usuario"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;


@Override
@Transactional
public UsuarioEntity actualizar(Integer codusu, UsuarioEntity datos) {

    if (codusu == null || codusu <= 0) {
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, "ID invalido");
    }

    if (datos == null) {
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, "Body obligatorio");
    }

    if (datos.getNomusu() == null ||
        datos.getNomusu().trim().isEmpty() ||
        datos.getNomusu().trim().length() > 50) {
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, "Campo nomusu invalido");
    }

    if (datos.getCorusu() == null ||
        datos.getCorusu().trim().isEmpty() ||
        datos.getCorusu().trim().length() > 100) {
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, "Campo corusu invalido");
    }

    if (datos.getEstusu() == null) {
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, "Campo estusu obligatorio");
    }

    if (datos.getCodalu() != null) {
        if (datos.getCodalu() <= 0 ||
            entityManager.find(AlumnoEntity.class, datos.getCodalu()) == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Referencia codalu invalida");
        }
    }

    if (datos.getCoddoc() != null) {
        if (datos.getCoddoc() <= 0 ||
            entityManager.find(DocenteEntity.class, datos.getCoddoc()) == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Referencia coddoc invalida");
        }
    }

    if (datos.getCodemp() != null) {
        if (datos.getCodemp() <= 0 ||
            entityManager.find(EmpleadoEntity.class, datos.getCodemp()) == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Referencia codemp invalida");
        }
    }

    UsuarioEntity actual = repository.findById(codusu)
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Usuario no encontrado"));

    actual.setNomusu(datos.getNomusu().trim());
    actual.setCorusu(datos.getCorusu().trim());
    actual.setEstusu(datos.getEstusu());

    actual.setCodalu(datos.getCodalu());
    actual.setCoddoc(datos.getCoddoc());
    actual.setCodemp(datos.getCodemp());

    return repository.save(actual);
}

}
