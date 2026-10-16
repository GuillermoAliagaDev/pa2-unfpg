package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.GradoInstruccionEntity;

public interface GradoInstruccionService {
    List<GradoInstruccionEntity> listar();
    GradoInstruccionEntity buscarPorId(Integer codgrai);
    GradoInstruccionEntity actualizar(Integer codgrai, GradoInstruccionEntity datos);
    GradoInstruccionEntity deshabilitar(Integer codgrai);
    GradoInstruccionEntity habilitar(Integer codgrai);
}
