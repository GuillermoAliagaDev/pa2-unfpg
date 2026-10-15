package pe.com.unfpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.unfpg.entity.UsuarioRolEntity;
import pe.com.unfpg.entity.UsuarioRolId;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRolEntity, UsuarioRolId> {}
