package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "calificacion")
public class CalificacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcal", nullable = false)
    private Integer codcal;

    @Column(name = "feccal", nullable = false)
    private LocalDateTime feccal;

    @Column(name = "nota", nullable = false, precision = 5, scale = 2)
    private BigDecimal nota;

    @Column(name = "coddet", nullable = false)
    private Integer coddet;

    @Column(name = "codsec", nullable = false)
    private Integer codsec;

    @Column(name = "codtipc", nullable = false)
    private Integer codtipc;

    public CalificacionEntity() {}

    public Integer getCodcal() { return codcal; }
    public void setCodcal(Integer codcal) { this.codcal = codcal; }

    public LocalDateTime getFeccal() { return feccal; }
    public void setFeccal(LocalDateTime feccal) { this.feccal = feccal; }

    public BigDecimal getNota() { return nota; }
    public void setNota(BigDecimal nota) { this.nota = nota; }

    public Integer getCoddet() { return coddet; }
    public void setCoddet(Integer coddet) { this.coddet = coddet; }

    public Integer getCodsec() { return codsec; }
    public void setCodsec(Integer codsec) { this.codsec = codsec; }

    public Integer getCodtipc() { return codtipc; }
    public void setCodtipc(Integer codtipc) { this.codtipc = codtipc; }

}
