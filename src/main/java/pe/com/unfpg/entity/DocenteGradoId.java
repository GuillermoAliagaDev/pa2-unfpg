package pe.com.unfpg.entity;

import java.io.Serializable;
import java.util.Objects;

public class DocenteGradoId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer coddoc;
    private Integer codgrai;
    public DocenteGradoId() {}
    public DocenteGradoId(Integer coddoc, Integer codgrai) {
        this.coddoc = coddoc;
        this.codgrai = codgrai;
    }
    public Integer getCoddoc() { return coddoc; }
    public void setCoddoc(Integer value) { this.coddoc = value; }
    public Integer getCodgrai() { return codgrai; }
    public void setCodgrai(Integer value) { this.codgrai = value; }
    @Override public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof DocenteGradoId)) return false;
        DocenteGradoId that = (DocenteGradoId) other;
        return Objects.equals(coddoc, that.coddoc) && Objects.equals(codgrai, that.codgrai);
    }
    @Override public int hashCode() { return Objects.hash(coddoc, codgrai); }
}
