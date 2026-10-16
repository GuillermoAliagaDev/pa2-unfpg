package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.AlumnoEntity;

public interface AlumnoService {
    List<AlumnoEntity> listar();
    AlumnoEntity buscarPorId(Integer codalu);
    AlumnoEntity actualizar(Integer codalu, AlumnoEntity datos);
    AlumnoEntity deshabilitar(Integer codalu);
    AlumnoEntity habilitar(Integer codalu);
}
