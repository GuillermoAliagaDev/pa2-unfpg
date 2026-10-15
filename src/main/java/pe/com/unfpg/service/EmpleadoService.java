package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.EmpleadoEntity;

public interface EmpleadoService {
    List<EmpleadoEntity> listar();
    EmpleadoEntity buscarPorId(Integer codemp);
}
