package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "seccion")
public class SeccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codsec", nullable = false)
    private Integer codsec;

    @Column(name = "capsec", nullable = false)
    private Integer capsec;

    @Column(name = "codcur", nullable = false)
    private Integer codcur;

    @Column(name = "coddoc", nullable = false)
    private Integer coddoc;

    @Column(name = "codper", nullable = false)
    private Integer codper;

    public SeccionEntity() {}

    public Integer getCodsec() { return codsec; }
    public void setCodsec(Integer codsec) { this.codsec = codsec; }

    public Integer getCapsec() { return capsec; }
    public void setCapsec(Integer capsec) { this.capsec = capsec; }

    public Integer getCodcur() { return codcur; }
    public void setCodcur(Integer codcur) { this.codcur = codcur; }

    public Integer getCoddoc() { return coddoc; }
    public void setCoddoc(Integer coddoc) { this.coddoc = coddoc; }

    public Integer getCodper() { return codper; }
    public void setCodper(Integer codper) { this.codper = codper; }

}
