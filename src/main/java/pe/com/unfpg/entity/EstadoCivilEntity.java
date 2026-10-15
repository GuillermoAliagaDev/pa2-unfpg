package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "estadocivil")
public class EstadoCivilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codestc", nullable = false)
    private Integer codestc;

    @Column(name = "nomestc", nullable = false, length = 50)
    private String nomestc;

    @Column(name = "estestc", nullable = false)
    private Boolean estestc;

    public EstadoCivilEntity() {}

    public Integer getCodestc() { return codestc; }
    public void setCodestc(Integer codestc) { this.codestc = codestc; }

    public String getNomestc() { return nomestc; }
    public void setNomestc(String nomestc) { this.nomestc = nomestc; }

    public Boolean getEstestc() { return estestc; }
    public void setEstestc(Boolean estestc) { this.estestc = estestc; }

}
