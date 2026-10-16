package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.DistritoEntity;
import pe.com.unfpg.entity.DocenteEntity;
import pe.com.unfpg.entity.EstadoCivilEntity;
import pe.com.unfpg.entity.SexoEntity;
import pe.com.unfpg.entity.TipoDocumentoEntity;
import pe.com.unfpg.repository.DocenteRepository;
import pe.com.unfpg.service.DocenteService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class DocenteServiceImpl implements DocenteService {
    private final DocenteRepository repository;

    public DocenteServiceImpl(DocenteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DocenteEntity> listar() {
        return repository.findAll(Sort.by("coddoc"));
    }

    @Override
    public DocenteEntity buscarPorId(Integer coddoc) {
        if (coddoc == null || coddoc <= 0) throw ConsultaGetException.idInvalido("coddoc");
        return repository.findById(coddoc)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("docente"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public DocenteEntity actualizar(Integer coddoc, DocenteEntity datos) {
        if (coddoc == null || coddoc <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getNomdoc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomdoc obligatorio");
        if (datos.getNomdoc().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomdoc vacio");
        if (datos.getNomdoc() != null && datos.getNomdoc().length() > 50) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomdoc demasiado largo");
        if (datos.getApepdoc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apepdoc obligatorio");
        if (datos.getApepdoc().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apepdoc vacio");
        if (datos.getApepdoc() != null && datos.getApepdoc().length() > 40) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apepdoc demasiado largo");
        if (datos.getApemdoc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apemdoc obligatorio");
        if (datos.getApemdoc().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apemdoc vacio");
        if (datos.getApemdoc() != null && datos.getApemdoc().length() > 40) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo apemdoc demasiado largo");
        if (datos.getFecnac() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo fecnac obligatorio");
        if (datos.getNumdoc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo numdoc obligatorio");
        if (datos.getNumdoc().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo numdoc vacio");
        if (datos.getNumdoc() != null && datos.getNumdoc().length() > 20) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo numdoc demasiado largo");
        if (datos.getNacdoc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nacdoc obligatorio");
        if (datos.getNacdoc().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nacdoc vacio");
        if (datos.getNacdoc() != null && datos.getNacdoc().length() > 20) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nacdoc demasiado largo");
        if (datos.getDirdoc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo dirdoc obligatorio");
        if (datos.getDirdoc().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo dirdoc vacio");
        if (datos.getTeldoc() != null && datos.getTeldoc().length() > 15) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo teldoc demasiado largo");
        if (datos.getCeldoc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo celdoc obligatorio");
        if (datos.getCeldoc().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo celdoc vacio");
        if (datos.getCeldoc() != null && datos.getCeldoc().length() > 15) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo celdoc demasiado largo");
        if (datos.getCordoc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo cordoc obligatorio");
        if (datos.getCordoc().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo cordoc vacio");
        if (datos.getCordoc() != null && datos.getCordoc().length() > 100) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo cordoc demasiado largo");
        if (datos.getEstdoc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estdoc obligatorio");
        if (datos.getSuedoc() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo suedoc obligatorio");
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
        DocenteEntity actual = repository.findById(coddoc).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Docente no encontrado"));
        actual.setNomdoc(datos.getNomdoc().trim());
        actual.setApepdoc(datos.getApepdoc().trim());
        actual.setApemdoc(datos.getApemdoc().trim());
        actual.setFecnac(datos.getFecnac());
        actual.setNumdoc(datos.getNumdoc().trim());
        actual.setNacdoc(datos.getNacdoc().trim());
        actual.setDirdoc(datos.getDirdoc().trim());
        actual.setTeldoc(datos.getTeldoc());
        actual.setCeldoc(datos.getCeldoc().trim());
        actual.setCordoc(datos.getCordoc().trim());
        actual.setEstdoc(datos.getEstdoc());
        actual.setSuedoc(datos.getSuedoc());
        actual.setCoddis(datos.getCoddis());
        actual.setCodsex(datos.getCodsex());
        actual.setCodtipd(datos.getCodtipd());
        actual.setCodestc(datos.getCodestc());
        return repository.save(actual);
    }
}
