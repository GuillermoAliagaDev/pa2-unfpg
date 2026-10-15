package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.TrasladoEntity;

public interface TrasladoService {
    List<TrasladoEntity> listar();
    TrasladoEntity buscarPorId(Integer codtra);
}
