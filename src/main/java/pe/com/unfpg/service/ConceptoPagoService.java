package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.ConceptoPagoEntity;

public interface ConceptoPagoService {
    List<ConceptoPagoEntity> listar();
    ConceptoPagoEntity buscarPorId(Integer codconp);
}
