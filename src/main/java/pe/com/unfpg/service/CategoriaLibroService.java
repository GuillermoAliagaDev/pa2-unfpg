package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.CategoriaLibroEntity;

public interface CategoriaLibroService {
    List<CategoriaLibroEntity> listar();
    CategoriaLibroEntity buscarPorId(Integer codcatl);
    CategoriaLibroEntity actualizar(Integer codcatl, CategoriaLibroEntity datos);
    CategoriaLibroEntity deshabilitar(Integer codcatl);
    CategoriaLibroEntity habilitar(Integer codcatl);
}
