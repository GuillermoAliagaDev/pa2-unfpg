package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.UsuarioEntity;

public interface UsuarioService {
    List<UsuarioEntity> listar();
    UsuarioEntity buscarPorId(Integer codusu);
    UsuarioEntity actualizar(Integer codusu, UsuarioEntity datos);
}
