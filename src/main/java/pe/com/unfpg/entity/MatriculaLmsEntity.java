package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "matriculalms")
public class MatriculaLmsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nummatl", nullable = false)
    private Integer nummatl;

    @Column(name = "fecmatl", nullable = false)
    private LocalDateTime fecmatl;

    @Column(name = "estmatl", nullable = false)
    private Boolean estmatl;

    @Column(name = "codalu", nullable = false)
    private Integer codalu;

    @Column(name = "codcurl", nullable = false)
    private Integer codcurl;

    @Column(name = "codroll", nullable = false)
    private Integer codroll;

    public MatriculaLmsEntity() {}

    public Integer getNummatl() { return nummatl; }
    public void setNummatl(Integer nummatl) { this.nummatl = nummatl; }

    public LocalDateTime getFecmatl() { return fecmatl; }
    public void setFecmatl(LocalDateTime fecmatl) { this.fecmatl = fecmatl; }

    public Boolean getEstmatl() { return estmatl; }
    public void setEstmatl(Boolean estmatl) { this.estmatl = estmatl; }

    public Integer getCodalu() { return codalu; }
    public void setCodalu(Integer codalu) { this.codalu = codalu; }

    public Integer getCodcurl() { return codcurl; }
    public void setCodcurl(Integer codcurl) { this.codcurl = codcurl; }

    public Integer getCodroll() { return codroll; }
    public void setCodroll(Integer codroll) { this.codroll = codroll; }

}
