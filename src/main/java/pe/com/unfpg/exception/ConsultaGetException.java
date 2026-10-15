package pe.com.unfpg.exception;

import org.springframework.http.HttpStatus;

public class ConsultaGetException extends RuntimeException {
    private final HttpStatus estado;
    private ConsultaGetException(HttpStatus estado, String mensaje) {
        super(mensaje);
        this.estado = estado;
    }
    public HttpStatus getEstado() { return estado; }
    public static ConsultaGetException idInvalido(String campo) {
        return new ConsultaGetException(HttpStatus.BAD_REQUEST, campo + " debe ser mayor que cero.");
    }
    public static ConsultaGetException noEncontrado(String tabla) {
        return new ConsultaGetException(HttpStatus.NOT_FOUND, "No existe el registro solicitado en " + tabla + ".");
    }
}
