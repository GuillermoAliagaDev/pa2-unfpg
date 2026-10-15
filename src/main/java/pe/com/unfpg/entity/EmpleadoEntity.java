package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "empleado")
public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codemp", nullable = false)
    private Integer codemp;

    @Column(name = "nomemp", nullable = false, length = 50)
    private String nomemp;

    @Column(name = "apepemp", nullable = false, length = 40)
    private String apepemp;

    @Column(name = "apememp", nullable = false, length = 40)
    private String apememp;

    @Column(name = "fecnac", nullable = false)
    private LocalDate fecnac;

    @Column(name = "numdoc", nullable = false, length = 20)
    private String numdoc;

    @Column(name = "nacemp", nullable = false, length = 20)
    private String nacemp;

    @Column(name = "diremp", nullable = false, columnDefinition = "TEXT")
    private String diremp;

    @Column(name = "telemp", nullable = true, length = 15)
    private String telemp;

    @Column(name = "celemp", nullable = false, length = 15)
    private String celemp;

    @Column(name = "coremp", nullable = false, length = 100)
    private String coremp;

    @Column(name = "estemp", nullable = false)
    private Boolean estemp;

    @Column(name = "creemp", nullable = true)
    private LocalDateTime creemp;

    @Column(name = "sueemp", nullable = false, precision = 8, scale = 2)
    private BigDecimal sueemp;

    @Column(name = "codare", nullable = false)
    private Integer codare;

    @Column(name = "codcar", nullable = false)
    private Integer codcar;

    @Column(name = "coddis", nullable = false)
    private Integer coddis;

    @Column(name = "codsex", nullable = false)
    private Integer codsex;

    @Column(name = "codtipd", nullable = false)
    private Integer codtipd;

    @Column(name = "codestc", nullable = false)
    private Integer codestc;

    public EmpleadoEntity() {}

    public Integer getCodemp() { return codemp; }
    public void setCodemp(Integer codemp) { this.codemp = codemp; }

    public String getNomemp() { return nomemp; }
    public void setNomemp(String nomemp) { this.nomemp = nomemp; }

    public String getApepemp() { return apepemp; }
    public void setApepemp(String apepemp) { this.apepemp = apepemp; }

    public String getApememp() { return apememp; }
    public void setApememp(String apememp) { this.apememp = apememp; }

    public LocalDate getFecnac() { return fecnac; }
    public void setFecnac(LocalDate fecnac) { this.fecnac = fecnac; }

    public String getNumdoc() { return numdoc; }
    public void setNumdoc(String numdoc) { this.numdoc = numdoc; }

    public String getNacemp() { return nacemp; }
    public void setNacemp(String nacemp) { this.nacemp = nacemp; }

    public String getDiremp() { return diremp; }
    public void setDiremp(String diremp) { this.diremp = diremp; }

    public String getTelemp() { return telemp; }
    public void setTelemp(String telemp) { this.telemp = telemp; }

    public String getCelemp() { return celemp; }
    public void setCelemp(String celemp) { this.celemp = celemp; }

    public String getCoremp() { return coremp; }
    public void setCoremp(String coremp) { this.coremp = coremp; }

    public Boolean getEstemp() { return estemp; }
    public void setEstemp(Boolean estemp) { this.estemp = estemp; }

    public LocalDateTime getCreemp() { return creemp; }
    public void setCreemp(LocalDateTime creemp) { this.creemp = creemp; }

    public BigDecimal getSueemp() { return sueemp; }
    public void setSueemp(BigDecimal sueemp) { this.sueemp = sueemp; }

    public Integer getCodare() { return codare; }
    public void setCodare(Integer codare) { this.codare = codare; }

    public Integer getCodcar() { return codcar; }
    public void setCodcar(Integer codcar) { this.codcar = codcar; }

    public Integer getCoddis() { return coddis; }
    public void setCoddis(Integer coddis) { this.coddis = coddis; }

    public Integer getCodsex() { return codsex; }
    public void setCodsex(Integer codsex) { this.codsex = codsex; }

    public Integer getCodtipd() { return codtipd; }
    public void setCodtipd(Integer codtipd) { this.codtipd = codtipd; }

    public Integer getCodestc() { return codestc; }
    public void setCodestc(Integer codestc) { this.codestc = codestc; }

}
