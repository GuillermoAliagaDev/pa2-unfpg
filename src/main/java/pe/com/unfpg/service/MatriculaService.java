package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.MatriculaEntity;

public interface MatriculaService {
    List<MatriculaEntity> listar();
    MatriculaEntity buscarPorId(Integer nummat);
    MatriculaEntity actualizar(Integer nummat, MatriculaEntity datos);
}
