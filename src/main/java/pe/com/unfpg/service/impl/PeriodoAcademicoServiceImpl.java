package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.PeriodoAcademicoEntity;
import pe.com.unfpg.repository.PeriodoAcademicoRepository;
import pe.com.unfpg.service.PeriodoAcademicoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class PeriodoAcademicoServiceImpl implements PeriodoAcademicoService {
    private final PeriodoAcademicoRepository repository;

    public PeriodoAcademicoServiceImpl(PeriodoAcademicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PeriodoAcademicoEntity> listar() {
        return repository.findAll(Sort.by("codper"));
    }

    @Override
    public PeriodoAcademicoEntity buscarPorId(Integer codper) {
        if (codper == null || codper <= 0) throw ConsultaGetException.idInvalido("codper");
        return repository.findById(codper)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("periodoacademico"));
    }
    
    @Override
    @Transactional
    public PeriodoAcademicoEntity actualizar(Integer codper, PeriodoAcademicoEntity datos) {
        if (codper == null || codper <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getNomper() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomper obligatorio");
        if (datos.getNomper().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomper vacio");
        if (datos.getNomper() != null && datos.getNomper().length() > 20) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomper demasiado largo");
        if (datos.getEstper() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo estper obligatorio");
        PeriodoAcademicoEntity actual = repository.findById(codper).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PeriodoAcademico no encontrado"));
        actual.setNomper(datos.getNomper().trim());
        actual.setFecini(datos.getFecini());
        actual.setFecfin(datos.getFecfin());
        actual.setDesper(datos.getDesper());
        actual.setEstper(datos.getEstper());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public PeriodoAcademicoEntity deshabilitar(Integer codper) {
        if (codper == null || codper <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        PeriodoAcademicoEntity actual = repository.findById(codper)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PeriodoAcademico no encontrado"));
        actual.setEstper(false);
        return repository.save(actual);
    }

    @Override
    @Transactional
    public PeriodoAcademicoEntity habilitar(Integer codper) {
        if (codper == null || codper <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        PeriodoAcademicoEntity actual = repository.findById(codper)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PeriodoAcademico no encontrado"));
        actual.setEstper(true);
        return repository.save(actual);
    }
}
