package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.EstadoPagoEntity;

public interface EstadoPagoService {
    List<EstadoPagoEntity> listar();
    EstadoPagoEntity buscarPorId(Integer codestp);
    EstadoPagoEntity actualizar(Integer codestp, EstadoPagoEntity datos);
}
