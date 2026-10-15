package pe.com.unfpg.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "estadoaula")
public class EstadoAulaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codesta", nullable = false)
    private Integer codesta;

    @Column(name = "nomesta", nullable = false, length = 50)
    private String nomesta;

    @Column(name = "estesta", nullable = false)
    private Boolean estesta;

    public EstadoAulaEntity() {}

    public Integer getCodesta() { return codesta; }
    public void setCodesta(Integer codesta) { this.codesta = codesta; }

    public String getNomesta() { return nomesta; }
    public void setNomesta(String nomesta) { this.nomesta = nomesta; }

    public Boolean getEstesta() { return estesta; }
    public void setEstesta(Boolean estesta) { this.estesta = estesta; }

}
