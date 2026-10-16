package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.AsistenciaEntity;

public interface AsistenciaService {
    List<AsistenciaEntity> listar();
    AsistenciaEntity buscarPorId(Integer codasis);
    AsistenciaEntity actualizar(Integer codasis, AsistenciaEntity datos);
}
