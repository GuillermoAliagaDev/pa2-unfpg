package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.CursoLmsEntity;

public interface CursoLmsService {
    List<CursoLmsEntity> listar();
    CursoLmsEntity buscarPorId(Integer codcurl);
    CursoLmsEntity actualizar(Integer codcurl, CursoLmsEntity datos);
}
