package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.AreaEmpleoEntity;

public interface AreaEmpleoService {
    List<AreaEmpleoEntity> listar();
    AreaEmpleoEntity buscarPorId(Integer codare);
    
    AreaEmpleoEntity actualizar(
            Integer codare,
            AreaEmpleoEntity datos
        );
    AreaEmpleoEntity deshabilitar(Integer codare);
    AreaEmpleoEntity habilitar(Integer codare);
}
