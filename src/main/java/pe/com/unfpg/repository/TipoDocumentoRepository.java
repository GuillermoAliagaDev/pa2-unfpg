package pe.com.unfpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.unfpg.entity.TipoDocumentoEntity;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Integer> {}
