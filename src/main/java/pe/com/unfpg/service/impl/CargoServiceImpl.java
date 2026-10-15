package pe.com.unfpg.service.impl;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
}
