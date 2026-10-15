package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "planestudio")
public class PlanEstudioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codpla", nullable = false)
    private Integer codpla;

    @Column(name = "nompla", nullable = false, length = 100)
    private String nompla;

    @Column(name = "despla", nullable = true, columnDefinition = "TEXT")
    private String despla;

    @Column(name = "estpla", nullable = false)
    private Boolean estpla;

    @Column(name = "codprog", nullable = false)
    private Integer codprog;

    public PlanEstudioEntity() {}

    public Integer getCodpla() { return codpla; }
    public void setCodpla(Integer codpla) { this.codpla = codpla; }

    public String getNompla() { return nompla; }
    public void setNompla(String nompla) { this.nompla = nompla; }

    public String getDespla() { return despla; }
    public void setDespla(String despla) { this.despla = despla; }

    public Boolean getEstpla() { return estpla; }
    public void setEstpla(Boolean estpla) { this.estpla = estpla; }

    public Integer getCodprog() { return codprog; }
    public void setCodprog(Integer codprog) { this.codprog = codprog; }

}
