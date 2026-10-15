package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "empleadogrado")
@IdClass(EmpleadoGradoId.class)
public class EmpleadoGradoEntity {
    @Id
    @Column(name = "codemp", nullable = false)
    private Integer codemp;

    @Id
    @Column(name = "codgrai", nullable = false)
    private Integer codgrai;

    @Column(name = "institucion", nullable = false, length = 150)
    private String institucion;

    @Column(name = "anioobtencion", nullable = false)
    private LocalDate anioobtencion;

    @Column(name = "nomesp", nullable = false, length = 100)
    private String nomesp;

    public EmpleadoGradoEntity() {}

    public Integer getCodemp() { return codemp; }
    public void setCodemp(Integer codemp) { this.codemp = codemp; }

    public Integer getCodgrai() { return codgrai; }
    public void setCodgrai(Integer codgrai) { this.codgrai = codgrai; }

    public String getInstitucion() { return institucion; }
    public void setInstitucion(String institucion) { this.institucion = institucion; }

    public LocalDate getAnioobtencion() { return anioobtencion; }
    public void setAnioobtencion(LocalDate anioobtencion) { this.anioobtencion = anioobtencion; }

    public String getNomesp() { return nomesp; }
    public void setNomesp(String nomesp) { this.nomesp = nomesp; }

}
