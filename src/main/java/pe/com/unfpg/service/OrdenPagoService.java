package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.OrdenPagoEntity;

public interface OrdenPagoService {
    List<OrdenPagoEntity> listar();
    OrdenPagoEntity buscarPorId(Integer codordpag);
    OrdenPagoEntity actualizar(Integer codordpag, OrdenPagoEntity datos);
}
