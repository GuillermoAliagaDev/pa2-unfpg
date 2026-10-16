package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.SexoEntity;

public interface SexoService {
    List<SexoEntity> listar();
    SexoEntity buscarPorId(Integer codsex);
    SexoEntity actualizar(Integer codsex, SexoEntity datos);
    SexoEntity deshabilitar(Integer codsex);
    SexoEntity habilitar(Integer codsex);
}
