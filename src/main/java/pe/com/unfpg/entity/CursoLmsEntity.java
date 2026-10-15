package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "cursolms")
public class CursoLmsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcurl", nullable = false)
    private Integer codcurl;

    @Column(name = "codpla", nullable = false)
    private Integer codpla;

    @Column(name = "estcurl", nullable = false)
    private Boolean estcurl;

    @Column(name = "codsec", nullable = false)
    private Integer codsec;

    public CursoLmsEntity() {}

    public Integer getCodcurl() { return codcurl; }
    public void setCodcurl(Integer codcurl) { this.codcurl = codcurl; }

    public Integer getCodpla() { return codpla; }
    public void setCodpla(Integer codpla) { this.codpla = codpla; }

    public Boolean getEstcurl() { return estcurl; }
    public void setEstcurl(Boolean estcurl) { this.estcurl = estcurl; }

    public Integer getCodsec() { return codsec; }
    public void setCodsec(Integer codsec) { this.codsec = codsec; }

}
