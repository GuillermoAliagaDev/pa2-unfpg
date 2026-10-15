package pe.com.unfpg.entity;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioRolId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer codusu;
    private Integer codrol;
    public UsuarioRolId() {}
    public UsuarioRolId(Integer codusu, Integer codrol) {
        this.codusu = codusu;
        this.codrol = codrol;
    }
    public Integer getCodusu() { return codusu; }
    public void setCodusu(Integer value) { this.codusu = value; }
    public Integer getCodrol() { return codrol; }
    public void setCodrol(Integer value) { this.codrol = value; }
    @Override public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof UsuarioRolId)) return false;
        UsuarioRolId that = (UsuarioRolId) other;
        return Objects.equals(codusu, that.codusu) && Objects.equals(codrol, that.codrol);
    }
    @Override public int hashCode() { return Objects.hash(codusu, codrol); }
}
