package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.MetodoPagoEntity;

public interface MetodoPagoService {
    List<MetodoPagoEntity> listar();
    MetodoPagoEntity buscarPorId(Integer codmetp);
}
