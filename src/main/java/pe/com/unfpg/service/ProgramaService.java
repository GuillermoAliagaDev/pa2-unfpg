package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.ProgramaEntity;

public interface ProgramaService {
    List<ProgramaEntity> listar();
    ProgramaEntity buscarPorId(Integer codprog);
    ProgramaEntity actualizar(Integer codprog, ProgramaEntity datos);
}
