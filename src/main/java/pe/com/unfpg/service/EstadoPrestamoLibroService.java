package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.EstadoPrestamoLibroEntity;

public interface EstadoPrestamoLibroService {
    List<EstadoPrestamoLibroEntity> listar();
    EstadoPrestamoLibroEntity buscarPorId(Integer codestl);
    EstadoPrestamoLibroEntity actualizar(Integer codestl, EstadoPrestamoLibroEntity datos);
    EstadoPrestamoLibroEntity deshabilitar(Integer codestl);
    EstadoPrestamoLibroEntity habilitar(Integer codestl);
}
