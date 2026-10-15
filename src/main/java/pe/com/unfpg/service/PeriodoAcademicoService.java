package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.PeriodoAcademicoEntity;

public interface PeriodoAcademicoService {
    List<PeriodoAcademicoEntity> listar();
    PeriodoAcademicoEntity buscarPorId(Integer codper);
}
