package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.CargoEntity;

public interface CargoService {
    List<CargoEntity> listar();
    CargoEntity buscarPorId(Integer codcar);
    CargoEntity actualizar(Integer codcar, CargoEntity datos);
}
