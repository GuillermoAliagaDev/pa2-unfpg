package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "docente")
public class DocenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coddoc", nullable = false)
    private Integer coddoc;

    @Column(name = "nomdoc", nullable = false, length = 50)
    private String nomdoc;

    @Column(name = "apepdoc", nullable = false, length = 40)
    private String apepdoc;

    @Column(name = "apemdoc", nullable = false, length = 40)
    private String apemdoc;

    @Column(name = "fecnac", nullable = false)
    private LocalDate fecnac;

    @Column(name = "numdoc", nullable = false, length = 20)
    private String numdoc;

    @Column(name = "nacdoc", nullable = false, length = 20)
    private String nacdoc;

    @Column(name = "dirdoc", nullable = false, columnDefinition = "TEXT")
    private String dirdoc;

    @Column(name = "teldoc", nullable = true, length = 15)
    private String teldoc;

    @Column(name = "celdoc", nullable = false, length = 15)
    private String celdoc;

    @Column(name = "cordoc", nullable = false, length = 100)
    private String cordoc;

    @Column(name = "estdoc", nullable = false)
    private Boolean estdoc;

    @Column(name = "credoc", nullable = true)
    private LocalDateTime credoc;

    @Column(name = "suedoc", nullable = false, precision = 8, scale = 2)
    private BigDecimal suedoc;

    @Column(name = "coddis", nullable = false)
    private Integer coddis;

    @Column(name = "codsex", nullable = false)
    private Integer codsex;

    @Column(name = "codtipd", nullable = false)
    private Integer codtipd;

    @Column(name = "codestc", nullable = false)
    private Integer codestc;

    public DocenteEntity() {}

    public Integer getCoddoc() { return coddoc; }
    public void setCoddoc(Integer coddoc) { this.coddoc = coddoc; }

    public String getNomdoc() { return nomdoc; }
    public void setNomdoc(String nomdoc) { this.nomdoc = nomdoc; }

    public String getApepdoc() { return apepdoc; }
    public void setApepdoc(String apepdoc) { this.apepdoc = apepdoc; }

    public String getApemdoc() { return apemdoc; }
    public void setApemdoc(String apemdoc) { this.apemdoc = apemdoc; }

    public LocalDate getFecnac() { return fecnac; }
    public void setFecnac(LocalDate fecnac) { this.fecnac = fecnac; }

    public String getNumdoc() { return numdoc; }
    public void setNumdoc(String numdoc) { this.numdoc = numdoc; }

    public String getNacdoc() { return nacdoc; }
    public void setNacdoc(String nacdoc) { this.nacdoc = nacdoc; }

    public String getDirdoc() { return dirdoc; }
    public void setDirdoc(String dirdoc) { this.dirdoc = dirdoc; }

    public String getTeldoc() { return teldoc; }
    public void setTeldoc(String teldoc) { this.teldoc = teldoc; }

    public String getCeldoc() { return celdoc; }
    public void setCeldoc(String celdoc) { this.celdoc = celdoc; }

    public String getCordoc() { return cordoc; }
    public void setCordoc(String cordoc) { this.cordoc = cordoc; }

    public Boolean getEstdoc() { return estdoc; }
    public void setEstdoc(Boolean estdoc) { this.estdoc = estdoc; }

    public LocalDateTime getCredoc() { return credoc; }
    public void setCredoc(LocalDateTime credoc) { this.credoc = credoc; }

    public BigDecimal getSuedoc() { return suedoc; }
    public void setSuedoc(BigDecimal suedoc) { this.suedoc = suedoc; }

    public Integer getCoddis() { return coddis; }
    public void setCoddis(Integer coddis) { this.coddis = coddis; }

    public Integer getCodsex() { return codsex; }
    public void setCodsex(Integer codsex) { this.codsex = codsex; }

    public Integer getCodtipd() { return codtipd; }
    public void setCodtipd(Integer codtipd) { this.codtipd = codtipd; }

    public Integer getCodestc() { return codestc; }
    public void setCodestc(Integer codestc) { this.codestc = codestc; }

}
