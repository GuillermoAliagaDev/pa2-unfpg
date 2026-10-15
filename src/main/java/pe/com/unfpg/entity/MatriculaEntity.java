package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "matricula")
public class MatriculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nummat", nullable = false)
    private Integer nummat;

    @Column(name = "obsmat", nullable = true, columnDefinition = "TEXT")
    private String obsmat;

    @Column(name = "fecmat", nullable = true)
    private LocalDateTime fecmat;

    @Column(name = "codalu", nullable = false)
    private Integer codalu;

    @Column(name = "codestm", nullable = false)
    private Integer codestm;

    @Column(name = "codtipm", nullable = false)
    private Integer codtipm;

    @Column(name = "codper", nullable = false)
    private Integer codper;

    @Column(name = "estmat", nullable = false)
    private Boolean estmat;

    public MatriculaEntity() {}

    public Integer getNummat() { return nummat; }
    public void setNummat(Integer nummat) { this.nummat = nummat; }

    public String getObsmat() { return obsmat; }
    public void setObsmat(String obsmat) { this.obsmat = obsmat; }

    public LocalDateTime getFecmat() { return fecmat; }
    public void setFecmat(LocalDateTime fecmat) { this.fecmat = fecmat; }

    public Integer getCodalu() { return codalu; }
    public void setCodalu(Integer codalu) { this.codalu = codalu; }

    public Integer getCodestm() { return codestm; }
    public void setCodestm(Integer codestm) { this.codestm = codestm; }

    public Integer getCodtipm() { return codtipm; }
    public void setCodtipm(Integer codtipm) { this.codtipm = codtipm; }

    public Integer getCodper() { return codper; }
    public void setCodper(Integer codper) { this.codper = codper; }

    public Boolean getEstmat() { return estmat; }
    public void setEstmat(Boolean estmat) { this.estmat = estmat; }

}
