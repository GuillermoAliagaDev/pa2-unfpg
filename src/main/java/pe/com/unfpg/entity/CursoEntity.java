package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "curso")
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcur", nullable = false)
    private Integer codcur;

    @Column(name = "sercur", nullable = false, length = 20)
    private String sercur;

    @Column(name = "nomcur", nullable = false, length = 150)
    private String nomcur;

    @Column(name = "crecur", nullable = false)
    private Integer crecur;

    @Column(name = "blocur", nullable = false)
    private Integer blocur;

    @Column(name = "codprog", nullable = false)
    private Integer codprog;

    public CursoEntity() {}

    public Integer getCodcur() { return codcur; }
    public void setCodcur(Integer codcur) { this.codcur = codcur; }

    public String getSercur() { return sercur; }
    public void setSercur(String sercur) { this.sercur = sercur; }

    public String getNomcur() { return nomcur; }
    public void setNomcur(String nomcur) { this.nomcur = nomcur; }

    public Integer getCrecur() { return crecur; }
    public void setCrecur(Integer crecur) { this.crecur = crecur; }

    public Integer getBlocur() { return blocur; }
    public void setBlocur(Integer blocur) { this.blocur = blocur; }

    public Integer getCodprog() { return codprog; }
    public void setCodprog(Integer codprog) { this.codprog = codprog; }

}
