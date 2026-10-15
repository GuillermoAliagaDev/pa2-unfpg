package pe.com.unfpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.unfpg.entity.EmpleadoGradoEntity;
import pe.com.unfpg.entity.EmpleadoGradoId;

public interface EmpleadoGradoRepository extends JpaRepository<EmpleadoGradoEntity, EmpleadoGradoId> {}
