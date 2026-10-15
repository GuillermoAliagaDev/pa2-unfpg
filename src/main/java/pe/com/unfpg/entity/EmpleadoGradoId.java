package pe.com.unfpg.entity;

import java.io.Serializable;
import java.util.Objects;

public class EmpleadoGradoId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer codemp;
    private Integer codgrai;
    public EmpleadoGradoId() {}
    public EmpleadoGradoId(Integer codemp, Integer codgrai) {
        this.codemp = codemp;
        this.codgrai = codgrai;
    }
    public Integer getCodemp() { return codemp; }
    public void setCodemp(Integer value) { this.codemp = value; }
    public Integer getCodgrai() { return codgrai; }
    public void setCodgrai(Integer value) { this.codgrai = value; }
    @Override public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof EmpleadoGradoId)) return false;
        EmpleadoGradoId that = (EmpleadoGradoId) other;
        return Objects.equals(codemp, that.codemp) && Objects.equals(codgrai, that.codgrai);
    }
    @Override public int hashCode() { return Objects.hash(codemp, codgrai); }
}
