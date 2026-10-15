package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.DocenteGradoEntity;

public interface DocenteGradoService {
    List<DocenteGradoEntity> listar();
    DocenteGradoEntity buscarPorId(Integer coddoc, Integer codgrai);
}
