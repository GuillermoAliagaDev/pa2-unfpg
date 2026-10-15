package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.DistritoEntity;

public interface DistritoService {
    List<DistritoEntity> listar();
    DistritoEntity buscarPorId(Integer coddis);
}
