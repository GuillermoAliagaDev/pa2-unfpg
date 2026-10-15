package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.CalificacionEntity;

public interface CalificacionService {
    List<CalificacionEntity> listar();
    CalificacionEntity buscarPorId(Integer codcal);
}
