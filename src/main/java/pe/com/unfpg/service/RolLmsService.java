package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.RolLmsEntity;

public interface RolLmsService {
    List<RolLmsEntity> listar();
    RolLmsEntity buscarPorId(Integer codroll);
    RolLmsEntity actualizar(Integer codroll, RolLmsEntity datos);
    RolLmsEntity deshabilitar(Integer codroll);
    RolLmsEntity habilitar(Integer codroll);
}
