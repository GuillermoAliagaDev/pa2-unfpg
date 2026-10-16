package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.EmpleadoEntity;

public interface EmpleadoService {
    List<EmpleadoEntity> listar();
    EmpleadoEntity buscarPorId(Integer codemp);
    EmpleadoEntity actualizar(Integer codemp, EmpleadoEntity datos);
    EmpleadoEntity deshabilitar(Integer codemp);
    EmpleadoEntity habilitar(Integer codemp);
}
