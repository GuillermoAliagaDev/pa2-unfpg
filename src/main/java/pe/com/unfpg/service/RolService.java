package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.RolEntity;

public interface RolService {
    List<RolEntity> listar();
    RolEntity buscarPorId(Integer codrol);
}
