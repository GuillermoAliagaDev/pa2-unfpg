package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.MatriculaLmsEntity;

public interface MatriculaLmsService {
	 List<MatriculaLmsEntity> listar();
    MatriculaLmsEntity buscarPorId(Integer nummatl);
    MatriculaLmsEntity actualizar(Integer nummatl, MatriculaLmsEntity datos);
}
