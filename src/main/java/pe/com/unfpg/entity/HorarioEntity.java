package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "horario")
public class HorarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codhor", nullable = false)
    private Integer codhor;

    @Column(name = "codblo", nullable = false)
    private Integer codblo;

    @Column(name = "codsec", nullable = false)
    private Integer codsec;

    @Column(name = "coddias", nullable = false)
    private Integer coddias;

    @Column(name = "codaul", nullable = false)
    private Integer codaul;

    public HorarioEntity() {}

    public Integer getCodhor() { return codhor; }
    public void setCodhor(Integer codhor) { this.codhor = codhor; }

    public Integer getCodblo() { return codblo; }
    public void setCodblo(Integer codblo) { this.codblo = codblo; }

    public Integer getCodsec() { return codsec; }
    public void setCodsec(Integer codsec) { this.codsec = codsec; }

    public Integer getCoddias() { return coddias; }
    public void setCoddias(Integer coddias) { this.coddias = coddias; }

    public Integer getCodaul() { return codaul; }
    public void setCodaul(Integer codaul) { this.codaul = codaul; }

}
