package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.BloqueEntity;

public interface BloqueService {
    List<BloqueEntity> listar();
    BloqueEntity buscarPorId(Integer codblo);
}
