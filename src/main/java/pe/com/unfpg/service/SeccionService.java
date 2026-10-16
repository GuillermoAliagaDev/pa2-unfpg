package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.SeccionEntity;

public interface SeccionService {
    List<SeccionEntity> listar();
    SeccionEntity buscarPorId(Integer codsec);
    SeccionEntity actualizar(Integer codsec, SeccionEntity datos);

    void eliminar(Integer codsec);
}
