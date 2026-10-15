package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tipoaula")
public class TipoAulaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codtipa", nullable = false)
    private Integer codtipa;

    @Column(name = "nomtipa", nullable = false, length = 50)
    private String nomtipa;

    @Column(name = "esttipa", nullable = false)
    private Boolean esttipa;

    public TipoAulaEntity() {}

    public Integer getCodtipa() { return codtipa; }
    public void setCodtipa(Integer codtipa) { this.codtipa = codtipa; }

    public String getNomtipa() { return nomtipa; }
    public void setNomtipa(String nomtipa) { this.nomtipa = nomtipa; }

    public Boolean getEsttipa() { return esttipa; }
    public void setEsttipa(Boolean esttipa) { this.esttipa = esttipa; }

}
