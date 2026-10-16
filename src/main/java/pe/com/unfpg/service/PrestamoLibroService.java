package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.PrestamoLibroEntity;

public interface PrestamoLibroService {
    List<PrestamoLibroEntity> listar();
    PrestamoLibroEntity buscarPorId(Integer numpre);
    PrestamoLibroEntity actualizar(Integer numpre, PrestamoLibroEntity datos);
}
