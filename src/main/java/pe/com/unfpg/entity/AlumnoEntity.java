package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "alumno")
public class AlumnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codalu", nullable = false)
    private Integer codalu;

    @Column(name = "nomalu", nullable = false, length = 50)
    private String nomalu;

    @Column(name = "apepalu", nullable = false, length = 40)
    private String apepalu;

    @Column(name = "apemalu", nullable = false, length = 40)
    private String apemalu;

    @Column(name = "fecnac", nullable = false)
    private LocalDate fecnac;

    @Column(name = "numdoc", nullable = false, length = 20)
    private String numdoc;

    @Column(name = "nacalu", nullable = false, length = 20)
    private String nacalu;

    @Column(name = "diralu", nullable = false, columnDefinition = "TEXT")
    private String diralu;

    @Column(name = "telalu", nullable = true, length = 15)
    private String telalu;

    @Column(name = "celalu", nullable = true, length = 15)
    private String celalu;

    @Column(name = "coralu", nullable = false, length = 100)
    private String coralu;

    @Column(name = "estalu", nullable = false)
    private Boolean estalu;

    @Column(name = "crealu", nullable = true)
    private LocalDateTime crealu;

    @Column(name = "coddis", nullable = false)
    private Integer coddis;

    @Column(name = "codsex", nullable = false)
    private Integer codsex;

    @Column(name = "codtipd", nullable = false)
    private Integer codtipd;

    @Column(name = "codestc", nullable = false)
    private Integer codestc;

    public AlumnoEntity() {}

    public Integer getCodalu() { return codalu; }
    public void setCodalu(Integer codalu) { this.codalu = codalu; }

    public String getNomalu() { return nomalu; }
    public void setNomalu(String nomalu) { this.nomalu = nomalu; }

    public String getApepalu() { return apepalu; }
    public void setApepalu(String apepalu) { this.apepalu = apepalu; }

    public String getApemalu() { return apemalu; }
    public void setApemalu(String apemalu) { this.apemalu = apemalu; }

    public LocalDate getFecnac() { return fecnac; }
    public void setFecnac(LocalDate fecnac) { this.fecnac = fecnac; }

    public String getNumdoc() { return numdoc; }
    public void setNumdoc(String numdoc) { this.numdoc = numdoc; }

    public String getNacalu() { return nacalu; }
    public void setNacalu(String nacalu) { this.nacalu = nacalu; }

    public String getDiralu() { return diralu; }
    public void setDiralu(String diralu) { this.diralu = diralu; }

    public String getTelalu() { return telalu; }
    public void setTelalu(String telalu) { this.telalu = telalu; }

    public String getCelalu() { return celalu; }
    public void setCelalu(String celalu) { this.celalu = celalu; }

    public String getCoralu() { return coralu; }
    public void setCoralu(String coralu) { this.coralu = coralu; }

    public Boolean getEstalu() { return estalu; }
    public void setEstalu(Boolean estalu) { this.estalu = estalu; }

    public LocalDateTime getCrealu() { return crealu; }
    public void setCrealu(LocalDateTime crealu) { this.crealu = crealu; }

    public Integer getCoddis() { return coddis; }
    public void setCoddis(Integer coddis) { this.coddis = coddis; }

    public Integer getCodsex() { return codsex; }
    public void setCodsex(Integer codsex) { this.codsex = codsex; }

    public Integer getCodtipd() { return codtipd; }
    public void setCodtipd(Integer codtipd) { this.codtipd = codtipd; }

    public Integer getCodestc() { return codestc; }
    public void setCodestc(Integer codestc) { this.codestc = codestc; }

}
