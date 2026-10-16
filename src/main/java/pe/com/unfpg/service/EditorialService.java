package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.EditorialEntity;

public interface EditorialService {
    List<EditorialEntity> listar();
    EditorialEntity buscarPorId(Integer codedi);
    EditorialEntity actualizar(Integer codedi, EditorialEntity datos);
    EditorialEntity deshabilitar(Integer codedi);
    EditorialEntity habilitar(Integer codedi);
}
