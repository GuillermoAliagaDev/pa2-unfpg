package pe.com.unfpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.unfpg.entity.EmpleadoEntity;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {}
