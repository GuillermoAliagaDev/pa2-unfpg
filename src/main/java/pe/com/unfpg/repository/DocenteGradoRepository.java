package pe.com.unfpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.unfpg.entity.DocenteGradoEntity;
import pe.com.unfpg.entity.DocenteGradoId;

public interface DocenteGradoRepository extends JpaRepository<DocenteGradoEntity, DocenteGradoId> {}
