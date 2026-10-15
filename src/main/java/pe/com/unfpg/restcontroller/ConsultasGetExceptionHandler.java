package pe.com.unfpg.restcontroller;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import pe.com.unfpg.exception.ConsultaGetException;

@RestControllerAdvice(basePackages = "pe.com.unfpg.restcontroller")
public class ConsultasGetExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ConsultasGetExceptionHandler.class);
    @ExceptionHandler(ConsultaGetException.class)
    public ResponseEntity<Map<String, Object>> consulta(ConsultaGetException ex) {
        return ResponseEntity.status(ex.getEstado()).body(Map.of("estado", ex.getEstado().value(), "mensaje", ex.getMessage()));
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> formato(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity.badRequest().body(Map.of("estado", 400, "mensaje", "El identificador debe ser un numero entero valido."));
    }
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Map<String, Object>> datos(DataAccessException ex) {
        LOG.error("Error al consultar la base de datos", ex);
        return ResponseEntity.internalServerError().body(Map.of("estado", 500, "mensaje", "No se pudo consultar la base de datos."));
    }
}
