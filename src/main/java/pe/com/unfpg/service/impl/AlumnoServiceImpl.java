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
import pe.com.unfpg.entity.DistritoEntity;
import pe.com.unfpg.entity.EstadoCivilEntity;
import pe.com.unfpg.entity.SexoEntity;
import pe.com.unfpg.entity.TipoDocumentoEntity;
import pe.com.unfpg.repository.AlumnoRepository;
import pe.com.unfpg.service.AlumnoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class AlumnoServiceImpl implements AlumnoService {
    private final AlumnoRepository repository;

    public AlumnoServiceImpl(AlumnoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AlumnoEntity> listar() {
        return repository.findAll(Sort.by("codalu"));
    }

    @Override
    public AlumnoEntity buscarPorId(Integer codalu) {
        if (codalu == null || codalu <= 0) throw ConsultaGetException.idInvalido("codalu");
        return repository.findById(codalu)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("alumno"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public AlumnoEntity actualizar(Integer codalu, AlumnoEntity datos) {
        if (codalu == null || codalu <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getNomalu() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomalu obligatorio");
        if (datos.getNomalu().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomalu vacio");
        if (datos.getNomalu() != null && datos.getNomalu().length() > 50) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomalu demasiado largo");
        if (datos.getApepalu() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apepalu obligatorio");
        if (datos.getApepalu().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apepalu vacio");
        if (datos.getApepalu() != null && datos.getApepalu().length() > 40) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apepalu demasiado largo");
        if (datos.getApemalu() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apemalu obligatorio");
        if (datos.getApemalu().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apemalu vacio");
        if (datos.getApemalu() != null && datos.getApemalu().length() > 40) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apemalu demasiado largo");
        if (datos.getFecnac() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo fecnac obligatorio");
        if (datos.getNumdoc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo numdoc obligatorio");
        if (datos.getNumdoc().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo numdoc vacio");
        if (datos.getNumdoc() != null && datos.getNumdoc().length() > 20) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo numdoc demasiado largo");
        if (datos.getNacalu() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nacalu obligatorio");
        if (datos.getNacalu().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nacalu vacio");
        if (datos.getNacalu() != null && datos.getNacalu().length() > 20) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nacalu demasiado largo");
        if (datos.getDiralu() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo diralu obligatorio");
        if (datos.getDiralu().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo diralu vacio");
        if (datos.getTelalu() != null && datos.getTelalu().length() > 15) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo telalu demasiado largo");
        if (datos.getCelalu() != null && datos.getCelalu().length() > 15) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo celalu demasiado largo");
        if (datos.getCoralu() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo coralu obligatorio");
        if (datos.getCoralu().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo coralu vacio");
        if (datos.getCoralu() != null && datos.getCoralu().length() > 100) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo coralu demasiado largo");
        if (datos.getEstalu() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estalu obligatorio");
        if (datos.getCoddis() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo coddis obligatorio");
        if (datos.getCoddis() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo coddis invalido");
        if (datos.getCodsex() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codsex obligatorio");
        if (datos.getCodsex() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codsex invalido");
        if (datos.getCodtipd() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codtipd obligatorio");
        if (datos.getCodtipd() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codtipd invalido");
        if (datos.getCodestc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codestc obligatorio");
        if (datos.getCodestc() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codestc invalido");
        if (datos.getCoddis() != null && entityManager.find(DistritoEntity.class, datos.getCoddis()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia coddis inexistente");
        if (datos.getCodsex() != null && entityManager.find(SexoEntity.class, datos.getCodsex()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codsex inexistente");
        if (datos.getCodtipd() != null && entityManager.find(TipoDocumentoEntity.class, datos.getCodtipd()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codtipd inexistente");
        if (datos.getCodestc() != null && entityManager.find(EstadoCivilEntity.class, datos.getCodestc()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codestc inexistente");
        AlumnoEntity actual = repository.findById(codalu).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no encontrado"));
        actual.setNomalu(datos.getNomalu().trim());
        actual.setApepalu(datos.getApepalu().trim());
        actual.setApemalu(datos.getApemalu().trim());
        actual.setFecnac(datos.getFecnac());
        actual.setNumdoc(datos.getNumdoc().trim());
        actual.setNacalu(datos.getNacalu().trim());
        actual.setDiralu(datos.getDiralu().trim());
        actual.setTelalu(datos.getTelalu());
        actual.setCelalu(datos.getCelalu());
        actual.setCoralu(datos.getCoralu().trim());
        actual.setEstalu(datos.getEstalu());
        actual.setCoddis(datos.getCoddis());
        actual.setCodsex(datos.getCodsex());
        actual.setCodtipd(datos.getCodtipd());
        actual.setCodestc(datos.getCodestc());
        return repository.save(actual);
    }


    @Override
    @Transactional
    public AlumnoEntity deshabilitar(Integer codalu) {
        if (codalu == null || codalu <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        AlumnoEntity actual = repository.findById(codalu)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no encontrado"));
        actual.setEstalu(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public AlumnoEntity habilitar(Integer codalu) {
        if (codalu == null || codalu <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        AlumnoEntity actual = repository.findById(codalu)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no encontrado"));
        actual.setEstalu(true);
        return repository.save(actual);
    }
}
