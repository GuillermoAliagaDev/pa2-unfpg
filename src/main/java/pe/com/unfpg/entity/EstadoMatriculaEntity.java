package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "estadomatricula")
public class EstadoMatriculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codestm", nullable = false)
    private Integer codestm;

    @Column(name = "nomestm", nullable = false, length = 30)
    private String nomestm;

    @Column(name = "estestm", nullable = false)
    private Boolean estestm;

    public EstadoMatriculaEntity() {}

    public Integer getCodestm() { return codestm; }
    public void setCodestm(Integer codestm) { this.codestm = codestm; }

    public String getNomestm() { return nomestm; }
    public void setNomestm(String nomestm) { this.nomestm = nomestm; }

    public Boolean getEstestm() { return estestm; }
    public void setEstestm(Boolean estestm) { this.estestm = estestm; }

}
