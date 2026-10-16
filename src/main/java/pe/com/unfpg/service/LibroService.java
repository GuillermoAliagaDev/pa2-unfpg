package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.LibroEntity;

public interface LibroService {
    List<LibroEntity> listar();
    LibroEntity buscarPorId(Integer codlib);
    LibroEntity actualizar(Integer codlib, LibroEntity datos);
    LibroEntity deshabilitar(Integer codlib);
    LibroEntity habilitar(Integer codlib);
}
