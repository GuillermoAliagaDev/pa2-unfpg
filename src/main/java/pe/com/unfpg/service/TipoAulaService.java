package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.TipoAulaEntity;

public interface TipoAulaService {
    List<TipoAulaEntity> listar();
    TipoAulaEntity buscarPorId(Integer codtipa);
    TipoAulaEntity actualizar(Integer codtipa, TipoAulaEntity datos);
}
