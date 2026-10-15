package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "asistencia")
public class AsistenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codasis", nullable = false)
    private Integer codasis;

    @Column(name = "fecasis", nullable = false)
    private LocalDateTime fecasis;

    @Column(name = "presente", nullable = false)
    private Boolean presente;

    @Column(name = "justificada", nullable = false)
    private Boolean justificada;

    @Column(name = "coddet", nullable = false)
    private Integer coddet;

    @Column(name = "codsec", nullable = false)
    private Integer codsec;

    public AsistenciaEntity() {}

    public Integer getCodasis() { return codasis; }
    public void setCodasis(Integer codasis) { this.codasis = codasis; }

    public LocalDateTime getFecasis() { return fecasis; }
    public void setFecasis(LocalDateTime fecasis) { this.fecasis = fecasis; }

    public Boolean getPresente() { return presente; }
    public void setPresente(Boolean presente) { this.presente = presente; }

    public Boolean getJustificada() { return justificada; }
    public void setJustificada(Boolean justificada) { this.justificada = justificada; }

    public Integer getCoddet() { return coddet; }
    public void setCoddet(Integer coddet) { this.coddet = coddet; }

    public Integer getCodsec() { return codsec; }
    public void setCodsec(Integer codsec) { this.codsec = codsec; }

}
