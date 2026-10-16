package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.DetalleMatriculaEntity;

public interface DetalleMatriculaService {
    List<DetalleMatriculaEntity> listar();
    DetalleMatriculaEntity buscarPorId(Integer coddet);
    DetalleMatriculaEntity actualizar(Integer coddet, DetalleMatriculaEntity datos);
}
