package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.EstadoPrestamoLibroEntity;

public interface EstadoPrestamoLibroService {
    List<EstadoPrestamoLibroEntity> listar();
    EstadoPrestamoLibroEntity buscarPorId(Integer codestl);
}
