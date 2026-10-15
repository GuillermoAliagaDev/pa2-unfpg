package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "sexo")
public class SexoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codsex", nullable = false)
    private Integer codsex;

    @Column(name = "nomsex", nullable = false, length = 30)
    private String nomsex;

    @Column(name = "estsex", nullable = false)
    private Boolean estsex;

    public SexoEntity() {}

    public Integer getCodsex() { return codsex; }
    public void setCodsex(Integer codsex) { this.codsex = codsex; }

    public String getNomsex() { return nomsex; }
    public void setNomsex(String nomsex) { this.nomsex = nomsex; }

    public Boolean getEstsex() { return estsex; }
    public void setEstsex(Boolean estsex) { this.estsex = estsex; }

}
