package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.EstadoAulaEntity;

public interface EstadoAulaService {
    List<EstadoAulaEntity> listar();
    EstadoAulaEntity buscarPorId(Integer codesta);
    EstadoAulaEntity actualizar(Integer codesta, EstadoAulaEntity datos);
}
