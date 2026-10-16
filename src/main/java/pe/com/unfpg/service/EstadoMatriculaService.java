package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.EstadoMatriculaEntity;

public interface EstadoMatriculaService {
    List<EstadoMatriculaEntity> listar();
    EstadoMatriculaEntity buscarPorId(Integer codestm);
    EstadoMatriculaEntity actualizar(Integer codestm, EstadoMatriculaEntity datos);
    EstadoMatriculaEntity deshabilitar(Integer codestm);
    EstadoMatriculaEntity habilitar(Integer codestm);
}
