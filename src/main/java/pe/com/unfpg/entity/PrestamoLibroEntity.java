package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "prestamolibro")
public class PrestamoLibroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numpre", nullable = false)
    private Integer numpre;

    @Column(name = "fecpre", nullable = false)
    private LocalDate fecpre;

    @Column(name = "fecdpre", nullable = true)
    private LocalDate fecdpre;

    @Column(name = "devpre", nullable = false)
    private Boolean devpre;

    @Column(name = "estpre", nullable = false)
    private Boolean estpre;

    @Column(name = "codalu", nullable = false)
    private Integer codalu;

    @Column(name = "codeje", nullable = false)
    private Integer codeje;

    @Column(name = "codestl", nullable = false)
    private Integer codestl;

    public PrestamoLibroEntity() {}

    public Integer getNumpre() { return numpre; }
    public void setNumpre(Integer numpre) { this.numpre = numpre; }

    public LocalDate getFecpre() { return fecpre; }
    public void setFecpre(LocalDate fecpre) { this.fecpre = fecpre; }

    public LocalDate getFecdpre() { return fecdpre; }
    public void setFecdpre(LocalDate fecdpre) { this.fecdpre = fecdpre; }

    public Boolean getDevpre() { return devpre; }
    public void setDevpre(Boolean devpre) { this.devpre = devpre; }

    public Boolean getEstpre() { return estpre; }
    public void setEstpre(Boolean estpre) { this.estpre = estpre; }

    public Integer getCodalu() { return codalu; }
    public void setCodalu(Integer codalu) { this.codalu = codalu; }

    public Integer getCodeje() { return codeje; }
    public void setCodeje(Integer codeje) { this.codeje = codeje; }

    public Integer getCodestl() { return codestl; }
    public void setCodestl(Integer codestl) { this.codestl = codestl; }

}
