package pe.com.unfpg.service;

import java.util.List;
import pe.com.unfpg.entity.TipoDocumentoEntity;

public interface TipoDocumentoService {
    List<TipoDocumentoEntity> listar();
    TipoDocumentoEntity buscarPorId(Integer codtipd);
    TipoDocumentoEntity actualizar(Integer codtipd, TipoDocumentoEntity datos);
    TipoDocumentoEntity deshabilitar(Integer codtipd);
    TipoDocumentoEntity habilitar(Integer codtipd);
}
