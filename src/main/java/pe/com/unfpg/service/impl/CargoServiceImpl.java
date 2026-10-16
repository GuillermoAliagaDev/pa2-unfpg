package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import pe.com.unfpg.entity.CargoEntity;
import pe.com.unfpg.repository.CargoRepository;
import pe.com.unfpg.service.CargoService;
import pe.com.unfpg.exception.ConsultaGetException;

@Service
@Transactional(readOnly = true)
public class CargoServiceImpl implements CargoService {
    private final CargoRepository repository;

    public CargoServiceImpl(CargoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CargoEntity> listar() {
        return repository.findAll(Sort.by("codcar"));
    }

    @Override
    public CargoEntity buscarPorId(Integer codcar) {
        if (codcar == null || codcar <= 0) throw ConsultaGetException.idInvalido("codcar");
        return repository.findById(codcar)
            .orElseThrow(() -> ConsultaGetException.noEncontrado("cargo"));
    }
    
    @Override
    @Transactional
    public CargoEntity actualizar(Integer codcar, CargoEntity datos) {
        if (codcar == null || codcar <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador invalido");
        }
        if (datos == null || datos.getNomcar() == null || datos.getNomcar().trim().isEmpty() || datos.getNomcar().trim().length() > 50 || datos.getEstcar() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos invalidos");
        }
        CargoEntity existente = repository.findById(codcar)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo no encontrado"));
        existente.setNomcar(datos.getNomcar().trim());
        existente.setEstcar(datos.getEstcar());
        return repository.save(existente);
    }

}
