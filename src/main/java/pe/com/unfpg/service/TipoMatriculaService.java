package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.TipoMatriculaEntity;

public interface TipoMatriculaService {
    List<TipoMatriculaEntity> listar();
    TipoMatriculaEntity buscarPorId(Integer codtipm);
    TipoMatriculaEntity actualizar(Integer codtipm, TipoMatriculaEntity datos);
}
