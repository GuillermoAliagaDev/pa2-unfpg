package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.EstadoCivilEntity;

public interface EstadoCivilService {
    List<EstadoCivilEntity> listar();
    EstadoCivilEntity buscarPorId(Integer codestc);
    EstadoCivilEntity actualizar(Integer codestc, EstadoCivilEntity datos);
}
