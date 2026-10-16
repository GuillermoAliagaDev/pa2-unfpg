package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.EvaluacionLmsEntity;

public interface EvaluacionLmsService {
    List<EvaluacionLmsEntity> listar();
    EvaluacionLmsEntity buscarPorId(Integer codeval);
    EvaluacionLmsEntity actualizar(Integer codeval, EvaluacionLmsEntity datos);
    EvaluacionLmsEntity deshabilitar(Integer codeval);
    EvaluacionLmsEntity habilitar(Integer codeval);
}
