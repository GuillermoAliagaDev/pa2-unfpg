package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.FacultadEntity;

public interface FacultadService {
    List<FacultadEntity> listar();
    FacultadEntity buscarPorId(Integer codfac);
    FacultadEntity actualizar(Integer codfac, FacultadEntity datos);
    FacultadEntity deshabilitar(Integer codfac);
    FacultadEntity habilitar(Integer codfac);
}
