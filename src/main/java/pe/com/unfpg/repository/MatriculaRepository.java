package pe.com.unfpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.unfpg.entity.MatriculaEntity;

public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Integer> {}
