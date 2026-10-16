package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.PlanEstudioEntity;

public interface PlanEstudioService {
    List<PlanEstudioEntity> listar();
    PlanEstudioEntity buscarPorId(Integer codpla);
    PlanEstudioEntity actualizar(Integer codpla, PlanEstudioEntity datos);
    PlanEstudioEntity deshabilitar(Integer codpla);
    PlanEstudioEntity habilitar(Integer codpla);
}
