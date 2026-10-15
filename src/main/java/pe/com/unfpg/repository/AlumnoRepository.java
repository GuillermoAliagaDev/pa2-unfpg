package pe.com.unfpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.unfpg.entity.AlumnoEntity;

public interface AlumnoRepository extends JpaRepository<AlumnoEntity, Integer> {}
