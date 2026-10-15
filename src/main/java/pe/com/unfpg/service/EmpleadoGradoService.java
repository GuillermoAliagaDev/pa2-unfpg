package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.EmpleadoGradoEntity;

public interface EmpleadoGradoService {
    List<EmpleadoGradoEntity> listar();
    EmpleadoGradoEntity buscarPorId(Integer codemp, Integer codgrai);
}
