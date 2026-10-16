
package pe.com.unfpg.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.AreaEmpleoEntity;
import pe.com.unfpg.repository.AreaEmpleoRepository;
import pe.com.unfpg.service.AreaEmpleoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class AreaEmpleoServiceImpl implements AreaEmpleoService {

    private final AreaEmpleoRepository repository;

    public AreaEmpleoServiceImpl(AreaEmpleoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AreaEmpleoEntity> listar() {
        return repository.findAll(Sort.by("codare"));
    }

    @Override
    public AreaEmpleoEntity buscarPorId(Integer codare) {
        if (codare == null || codare <= 0)
            throw ConsultaGetException.idInvalido("codare");

        return repository.findById(codare)
            .orElseThrow(() ->
                ConsultaGetException.noEncontrado("areaempleo"));
    }

    @Override
    @Transactional
    public AreaEmpleoEntity actualizar(
            Integer codare,
            AreaEmpleoEntity datos) {

        if (codare == null || codare <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El codigo debe ser mayor que cero"
            );
        }

        if (datos == null || datos.getNomare() == null
                || datos.getNomare().trim().isEmpty()
                || datos.getNomare().length() > 50
                || datos.getEstare() == null) {

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Nombre o estado invalido"
            );
        }

        AreaEmpleoEntity area = repository.findById(codare)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Area de empleo no encontrada"
                )
            );

        area.setNomare(datos.getNomare().trim());
        area.setEstare(datos.getEstare());

        return repository.save(area);
    }
}
