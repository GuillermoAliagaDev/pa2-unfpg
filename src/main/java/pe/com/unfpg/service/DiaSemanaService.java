package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.DiaSemanaEntity;

public interface DiaSemanaService {
    List<DiaSemanaEntity> listar();
    DiaSemanaEntity buscarPorId(Integer coddias);
}
