package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.EjemplarLibroEntity;

public interface EjemplarLibroService {
    List<EjemplarLibroEntity> listar();
    EjemplarLibroEntity buscarPorId(Integer codeje);
    EjemplarLibroEntity actualizar(Integer codeje, EjemplarLibroEntity datos);
    EjemplarLibroEntity deshabilitar(Integer codeje);
    EjemplarLibroEntity habilitar(Integer codeje);
}
