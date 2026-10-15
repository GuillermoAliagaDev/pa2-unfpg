package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "periodoacademico")
public class PeriodoAcademicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codper", nullable = false)
    private Integer codper;

    @Column(name = "nomper", nullable = false, length = 20)
    private String nomper;

    @Column(name = "fecini", nullable = true)
    private LocalDate fecini;

    @Column(name = "fecfin", nullable = true)
    private LocalDate fecfin;

    @Column(name = "desper", nullable = true, columnDefinition = "TEXT")
    private String desper;

    @Column(name = "estper", nullable = false)
    private Boolean estper;

    public PeriodoAcademicoEntity() {}

    public Integer getCodper() { return codper; }
    public void setCodper(Integer codper) { this.codper = codper; }

    public String getNomper() { return nomper; }
    public void setNomper(String nomper) { this.nomper = nomper; }

    public LocalDate getFecini() { return fecini; }
    public void setFecini(LocalDate fecini) { this.fecini = fecini; }

    public LocalDate getFecfin() { return fecfin; }
    public void setFecfin(LocalDate fecfin) { this.fecfin = fecfin; }

    public String getDesper() { return desper; }
    public void setDesper(String desper) { this.desper = desper; }

    public Boolean getEstper() { return estper; }
    public void setEstper(Boolean estper) { this.estper = estper; }

}
