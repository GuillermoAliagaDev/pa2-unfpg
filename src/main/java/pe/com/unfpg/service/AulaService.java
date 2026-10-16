package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.AulaEntity;

public interface AulaService {
    List<AulaEntity> listar();
    AulaEntity buscarPorId(Integer codaul);
    AulaEntity actualizar(Integer codaul, AulaEntity datos);
}
