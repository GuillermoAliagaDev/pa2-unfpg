package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.TipoCalificacionEntity;

public interface TipoCalificacionService {
    List<TipoCalificacionEntity> listar();
    TipoCalificacionEntity buscarPorId(Integer codtipc);
    TipoCalificacionEntity actualizar(Integer codtipc, TipoCalificacionEntity datos);
}
