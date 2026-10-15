package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "docentegrado")
@IdClass(DocenteGradoId.class)
public class DocenteGradoEntity {
    @Id
    @Column(name = "coddoc", nullable = false)
    private Integer coddoc;

    @Id
    @Column(name = "codgrai", nullable = false)
    private Integer codgrai;

    @Column(name = "institucion", nullable = false, length = 150)
    private String institucion;

    @Column(name = "anioobtencion", nullable = false)
    private LocalDate anioobtencion;

    @Column(name = "nomesp", nullable = false, length = 100)
    private String nomesp;

    public DocenteGradoEntity() {}

    public Integer getCoddoc() { return coddoc; }
    public void setCoddoc(Integer coddoc) { this.coddoc = coddoc; }

    public Integer getCodgrai() { return codgrai; }
    public void setCodgrai(Integer codgrai) { this.codgrai = codgrai; }

    public String getInstitucion() { return institucion; }
    public void setInstitucion(String institucion) { this.institucion = institucion; }

    public LocalDate getAnioobtencion() { return anioobtencion; }
    public void setAnioobtencion(LocalDate anioobtencion) { this.anioobtencion = anioobtencion; }

    public String getNomesp() { return nomesp; }
    public void setNomesp(String nomesp) { this.nomesp = nomesp; }

}
