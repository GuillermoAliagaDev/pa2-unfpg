package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.UsuarioRolEntity;

public interface UsuarioRolService {
    List<UsuarioRolEntity> listar();
    UsuarioRolEntity buscarPorId(Integer codusu, Integer codrol);
}
