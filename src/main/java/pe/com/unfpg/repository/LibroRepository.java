package pe.com.unfpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.unfpg.entity.LibroEntity;

public interface LibroRepository extends JpaRepository<LibroEntity, Integer> {}
