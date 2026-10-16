package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.UbicacionEntity;

public interface UbicacionService {
    List<UbicacionEntity> listar();
    UbicacionEntity buscarPorId(Integer codubi);
    UbicacionEntity actualizar(Integer codubi, UbicacionEntity datos);
    UbicacionEntity deshabilitar(Integer codubi);
    UbicacionEntity habilitar(Integer codubi);
}
