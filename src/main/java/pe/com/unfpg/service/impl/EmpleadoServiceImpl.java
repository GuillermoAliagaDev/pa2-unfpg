package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.AreaEmpleoEntity;
import pe.com.unfpg.entity.CargoEntity;
import pe.com.unfpg.entity.DistritoEntity;
import pe.com.unfpg.entity.EmpleadoEntity;
import pe.com.unfpg.entity.EstadoCivilEntity;
import pe.com.unfpg.entity.SexoEntity;
import pe.com.unfpg.entity.TipoDocumentoEntity;
import pe.com.unfpg.repository.EmpleadoRepository;
import pe.com.unfpg.service.EmpleadoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class EmpleadoServiceImpl implements EmpleadoService {
    private final EmpleadoRepository repository;

    public EmpleadoServiceImpl(EmpleadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmpleadoEntity> listar() {
        return repository.findAll(Sort.by("codemp"));
    }

    @Override
    public EmpleadoEntity buscarPorId(Integer codemp) {
        if (codemp == null || codemp <= 0) throw ConsultaGetException.idInvalido("codemp");
        return repository.findById(codemp)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("empleado"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public EmpleadoEntity actualizar(Integer codemp, EmpleadoEntity datos) {
        if (codemp == null || codemp <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getNomemp() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomemp obligatorio");
        if (datos.getNomemp().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomemp vacio");
        if (datos.getNomemp() != null && datos.getNomemp().length() > 50) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomemp demasiado largo");
        if (datos.getApepemp() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apepemp obligatorio");
        if (datos.getApepemp().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apepemp vacio");
        if (datos.getApepemp() != null && datos.getApepemp().length() > 40) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apepemp demasiado largo");
        if (datos.getApememp() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apememp obligatorio");
        if (datos.getApememp().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apememp vacio");
        if (datos.getApememp() != null && datos.getApememp().length() > 40) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apememp demasiado largo");
        if (datos.getFecnac() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo fecnac obligatorio");
        if (datos.getNumdoc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo numdoc obligatorio");
        if (datos.getNumdoc().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo numdoc vacio");
        if (datos.getNumdoc() != null && datos.getNumdoc().length() > 20) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo numdoc demasiado largo");
        if (datos.getNacemp() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nacemp obligatorio");
        if (datos.getNacemp().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nacemp vacio");
        if (datos.getNacemp() != null && datos.getNacemp().length() > 20) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nacemp demasiado largo");
        if (datos.getDiremp() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo diremp obligatorio");
        if (datos.getDiremp().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo diremp vacio");
        if (datos.getTelemp() != null && datos.getTelemp().length() > 15) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo telemp demasiado largo");
        if (datos.getCelemp() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo celemp obligatorio");
        if (datos.getCelemp().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo celemp vacio");
        if (datos.getCelemp() != null && datos.getCelemp().length() > 15) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo celemp demasiado largo");
        if (datos.getCoremp() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo coremp obligatorio");
        if (datos.getCoremp().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo coremp vacio");
        if (datos.getCoremp() != null && datos.getCoremp().length() > 100) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo coremp demasiado largo");
        if (datos.getEstemp() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estemp obligatorio");
        if (datos.getSueemp() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo sueemp obligatorio");
        if (datos.getCodare() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codare obligatorio");
        if (datos.getCodare() != null && datos.getCodare() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codare invalida");
        if (datos.getCodare() != null && entityManager.find(AreaEmpleoEntity.class, datos.getCodare()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codare inexistente");
        if (datos.getCodcar() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codcar obligatorio");
        if (datos.getCodcar() != null && datos.getCodcar() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codcar invalida");
        if (datos.getCodcar() != null && entityManager.find(CargoEntity.class, datos.getCodcar()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codcar inexistente");
        if (datos.getCoddis() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo coddis obligatorio");
        if (datos.getCoddis() != null && datos.getCoddis() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia coddis invalida");
        if (datos.getCoddis() != null && entityManager.find(DistritoEntity.class, datos.getCoddis()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia coddis inexistente");
        if (datos.getCodsex() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codsex obligatorio");
        if (datos.getCodsex() != null && datos.getCodsex() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codsex invalida");
        if (datos.getCodsex() != null && entityManager.find(SexoEntity.class, datos.getCodsex()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codsex inexistente");
        if (datos.getCodtipd() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codtipd obligatorio");
        if (datos.getCodtipd() != null && datos.getCodtipd() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codtipd invalida");
        if (datos.getCodtipd() != null && entityManager.find(TipoDocumentoEntity.class, datos.getCodtipd()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codtipd inexistente");
        if (datos.getCodestc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codestc obligatorio");
        if (datos.getCodestc() != null && datos.getCodestc() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codestc invalida");
        if (datos.getCodestc() != null && entityManager.find(EstadoCivilEntity.class, datos.getCodestc()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codestc inexistente");
        EmpleadoEntity actual = repository.findById(codemp).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado"));
        actual.setNomemp(datos.getNomemp().trim());
        actual.setApepemp(datos.getApepemp().trim());
        actual.setApememp(datos.getApememp().trim());
        actual.setFecnac(datos.getFecnac());
        actual.setNumdoc(datos.getNumdoc().trim());
        actual.setNacemp(datos.getNacemp().trim());
        actual.setDiremp(datos.getDiremp().trim());
        actual.setTelemp((datos.getTelemp() == null ? null : datos.getTelemp().trim()));
        actual.setCelemp(datos.getCelemp().trim());
        actual.setCoremp(datos.getCoremp().trim());
        actual.setEstemp(datos.getEstemp());
        actual.setSueemp(datos.getSueemp());
        actual.setCodare(datos.getCodare());
        actual.setCodcar(datos.getCodcar());
        actual.setCoddis(datos.getCoddis());
        actual.setCodsex(datos.getCodsex());
        actual.setCodtipd(datos.getCodtipd());
        actual.setCodestc(datos.getCodestc());
        return repository.save(actual);
    }


    @Override
    @Transactional
    public EmpleadoEntity deshabilitar(Integer codemp) {
        if (codemp == null || codemp <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        EmpleadoEntity actual = repository.findById(codemp)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado"));
        actual.setEstemp(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public EmpleadoEntity habilitar(Integer codemp) {
        if (codemp == null || codemp <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        EmpleadoEntity actual = repository.findById(codemp)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado"));
        actual.setEstemp(true);
        return repository.save(actual);
    }
}
