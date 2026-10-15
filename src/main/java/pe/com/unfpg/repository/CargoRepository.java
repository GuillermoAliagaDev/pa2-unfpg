package pe.com.unfpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.unfpg.entity.CargoEntity;

public interface CargoRepository extends JpaRepository<CargoEntity, Integer> {}
