package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "evaluacionlms")
public class EvaluacionLmsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeval", nullable = false)
    private Integer codeval;

    @Column(name = "nomeval", nullable = false, length = 100)
    private String nomeval;

    @Column(name = "deseval", nullable = true, columnDefinition = "TEXT")
    private String deseval;

    @Column(name = "feceval", nullable = false)
    private LocalDateTime feceval;

    @Column(name = "esteval", nullable = false)
    private Boolean esteval;

    @Column(name = "codcurl", nullable = false)
    private Integer codcurl;

    public EvaluacionLmsEntity() {}

    public Integer getCodeval() { return codeval; }
    public void setCodeval(Integer codeval) { this.codeval = codeval; }

    public String getNomeval() { return nomeval; }
    public void setNomeval(String nomeval) { this.nomeval = nomeval; }

    public String getDeseval() { return deseval; }
    public void setDeseval(String deseval) { this.deseval = deseval; }

    public LocalDateTime getFeceval() { return feceval; }
    public void setFeceval(LocalDateTime feceval) { this.feceval = feceval; }

    public Boolean getEsteval() { return esteval; }
    public void setEsteval(Boolean esteval) { this.esteval = esteval; }

    public Integer getCodcurl() { return codcurl; }
    public void setCodcurl(Integer codcurl) { this.codcurl = codcurl; }

}
