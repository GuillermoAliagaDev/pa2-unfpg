package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "programa")
public class ProgramaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codprog", nullable = false)
    private Integer codprog;

    @Column(name = "nomprog", nullable = false, length = 100)
    private String nomprog;

    @Column(name = "estprog", nullable = false)
    private Boolean estprog;

    @Column(name = "codfac", nullable = false)
    private Integer codfac;

    public ProgramaEntity() {}

    public Integer getCodprog() { return codprog; }
    public void setCodprog(Integer codprog) { this.codprog = codprog; }

    public String getNomprog() { return nomprog; }
    public void setNomprog(String nomprog) { this.nomprog = nomprog; }

    public Boolean getEstprog() { return estprog; }
    public void setEstprog(Boolean estprog) { this.estprog = estprog; }

    public Integer getCodfac() { return codfac; }
    public void setCodfac(Integer codfac) { this.codfac = codfac; }

}
