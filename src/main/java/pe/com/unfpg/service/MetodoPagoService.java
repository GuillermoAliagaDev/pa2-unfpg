package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.MetodoPagoEntity;

public interface MetodoPagoService {
    List<MetodoPagoEntity> listar();
    MetodoPagoEntity buscarPorId(Integer codmetp);
    MetodoPagoEntity actualizar(Integer codmetp, MetodoPagoEntity datos);
    MetodoPagoEntity deshabilitar(Integer codmetp);
    MetodoPagoEntity habilitar(Integer codmetp);
}
