package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.DocenteEntity;

public interface DocenteService {
    List<DocenteEntity> listar();
    DocenteEntity buscarPorId(Integer coddoc);
    DocenteEntity actualizar(Integer coddoc, DocenteEntity datos);
}
