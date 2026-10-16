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
import pe.com.unfpg.entity.EstadoAulaEntity;
import pe.com.unfpg.entity.TipoAulaEntity;
import pe.com.unfpg.entity.UbicacionEntity;
import pe.com.unfpg.repository.AulaRepository;
import pe.com.unfpg.service.AulaService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class AulaServiceImpl implements AulaService {
    private final AulaRepository repository;

    public AulaServiceImpl(AulaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AulaEntity> listar() {
        return repository.findAll(Sort.by("codaul"));
    }

    @Override
    public AulaEntity buscarPorId(Integer codaul) {
        if (codaul == null || codaul <= 0) throw ConsultaGetException.idInvalido("codaul");
        return repository.findById(codaul)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("aula"));
    }
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public AulaEntity actualizar(Integer codaul, AulaEntity datos) {
        if (codaul == null || codaul <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalido");
        if (datos == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Body obligatorio");
        if (datos.getNomaul() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomaul obligatorio");
        if (datos.getNomaul().trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomaul vacio");
        if (datos.getNomaul() != null && datos.getNomaul().length() > 50) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo nomaul demasiado largo");
        if (datos.getCapaul() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo capaul obligatorio");
        if (datos.getCapaul() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo capaul invalido");
        if (datos.getCodubi() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codubi obligatorio");
        if (datos.getCodubi() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codubi invalido");
        if (datos.getCodtipa() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codtipa obligatorio");
        if (datos.getCodtipa() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codtipa invalido");
        if (datos.getCodesta() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codesta obligatorio");
        if (datos.getCodesta() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo codesta invalido");
        if (datos.getCodubi() != null && entityManager.find(UbicacionEntity.class, datos.getCodubi()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codubi inexistente");
        if (datos.getCodtipa() != null && entityManager.find(TipoAulaEntity.class, datos.getCodtipa()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codtipa inexistente");
        if (datos.getCodesta() != null && entityManager.find(EstadoAulaEntity.class, datos.getCodesta()) == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Referencia codesta inexistente");
        AulaEntity actual = repository.findById(codaul).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula no encontrado"));
        actual.setNomaul(datos.getNomaul().trim());
        actual.setCapaul(datos.getCapaul());
        actual.setCodubi(datos.getCodubi());
        actual.setCodtipa(datos.getCodtipa());
        actual.setCodesta(datos.getCodesta());
        return repository.save(actual);
    }
}
