package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.PagoEntity;

public interface PagoService {
    List<PagoEntity> listar();
    PagoEntity buscarPorId(Integer codpag);
}
