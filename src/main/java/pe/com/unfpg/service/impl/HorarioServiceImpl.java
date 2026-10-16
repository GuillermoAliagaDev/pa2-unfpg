package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.com.unfpg.entity.AulaEntity;
import pe.com.unfpg.entity.BloqueEntity;
import pe.com.unfpg.entity.DiaSemanaEntity;
import pe.com.unfpg.entity.HorarioEntity;
import pe.com.unfpg.entity.SeccionEntity;
import pe.com.unfpg.repository.HorarioRepository;
import pe.com.unfpg.service.HorarioService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class HorarioServiceImpl implements HorarioService {
    private final HorarioRepository repository;

    public HorarioServiceImpl(HorarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<HorarioEntity> listar() {
        return repository.findAll(Sort.by("codhor"));
    }

    @Override
    public HorarioEntity buscarPorId(Integer codhor) {
        if (codhor == null || codhor <= 0) throw ConsultaGetException.idInvalido("codhor");
        return repository.findById(codhor)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("horario"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public HorarioEntity actualizar(Integer codhor, HorarioEntity datos) {
        if (codhor == null || codhor <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getCodblo() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codblo obligatorio");
        if (datos.getCodblo() != null && datos.getCodblo() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codblo invalida");
        if (datos.getCodblo() != null && entityManager.find(BloqueEntity.class, datos.getCodblo()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codblo inexistente");
        if (datos.getCodsec() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codsec obligatorio");
        if (datos.getCodsec() != null && datos.getCodsec() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codsec invalida");
        if (datos.getCodsec() != null && entityManager.find(SeccionEntity.class, datos.getCodsec()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codsec inexistente");
        if (datos.getCoddias() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo coddias obligatorio");
        if (datos.getCoddias() != null && datos.getCoddias() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia coddias invalida");
        if (datos.getCoddias() != null && entityManager.find(DiaSemanaEntity.class, datos.getCoddias()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia coddias inexistente");
        if (datos.getCodaul() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codaul obligatorio");
        if (datos.getCodaul() != null && datos.getCodaul() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codaul invalida");
        if (datos.getCodaul() != null && entityManager.find(AulaEntity.class, datos.getCodaul()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codaul inexistente");
        HorarioEntity actual = repository.findById(codhor).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Horario no encontrado"));
        actual.setCodblo(datos.getCodblo());
        actual.setCodsec(datos.getCodsec());
        actual.setCoddias(datos.getCoddias());
        actual.setCodaul(datos.getCodaul());
        return repository.save(actual);
    }

    @Override
    @Transactional
    public void eliminar(Integer codhor) {
        if (codhor == null || codhor <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        }
        HorarioEntity actual = repository.findById(codhor)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Horario no encontrado"));
        repository.delete(actual);
    }
}
