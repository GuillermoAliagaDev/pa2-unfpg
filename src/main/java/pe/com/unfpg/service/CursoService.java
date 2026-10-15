package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.CursoEntity;

public interface CursoService {
    List<CursoEntity> listar();
    CursoEntity buscarPorId(Integer codcur);
}
