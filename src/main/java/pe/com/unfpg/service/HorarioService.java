package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.HorarioEntity;

public interface HorarioService {
    List<HorarioEntity> listar();
    HorarioEntity buscarPorId(Integer codhor);
    HorarioEntity actualizar(Integer codhor, HorarioEntity datos);
    void eliminar(Integer codhor);
}
